package com.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * Created by Laura on 12/8/2017.
 */
public class ConnectionManager {

    private static List<Connection> connections = new ArrayList<>();
    private static List<Peer> peers = new ArrayList<>();
    private Executor executor;
    private String host;

    public ConnectionManager() {
        this.executor = Executors.newFixedThreadPool(4);
        this.host = "localhost";
    }

    public void addPeer(Peer peer) {
        executor.execute(peer);
        peers.add(peer);
    }

    public void connect(Peer peer1, Peer peer2) {
        try {
            Socket newSocket = new Socket(host, peer2.getPort());

            PrintWriter out = new PrintWriter(newSocket.getOutputStream(), true);
            out.println(peer1.getName());

            ChatWindow chatWindow = new ChatWindow(peer1.getName() + " to " + peer2.getName(),
                    peer1.getName(), peer2.getName(), newSocket);

            peer1.addChat(chatWindow);

            Connection connection = new Connection(peer1, peer2);
            connections.add(connection);

        } catch (IOException e) {
            throw new ChatException(e.getMessage());
        }
    }

    public static String processInput(String from, String to, String input) {

        Optional<Connection> connection = connections.stream()
                .filter(c -> (c.getInitiator().getName().equals(from) && c.getTarget().getName().equals(to)) ||
                        (c.getInitiator().getName().equals(to) && c.getTarget().getName().equals(from)))
                .findAny();

        if (connection.isPresent()) {
            Protocol protocol = connection.get().getProtocol();
            String message = protocol.processInput(input, from);
            State state = protocol.getState();

            if (state.equals(State.BROKEN) || state.equals(State.TERMINATED)) {
                Optional<Peer> peer = peers.stream()
                        .filter(p -> p.getName().equals(from))
                        .findAny();
                if (peer.isPresent()) {
                    peer.get().stopConnectionTo(to);
                    connections = connections.stream()
                            .filter(c -> !(c.getInitiator().getName().equals(from) && c.getTarget().getName().equals(to)) &&
                                    !(c.getInitiator().getName().equals(to) && c.getTarget().getName().equals(from)))
                            .collect(Collectors.toList());
                } else {
                    throw new ChatException("There is no connection from " + from + "!");
                }

            } else if (state.equals(State.TERMINATED_ALL)) {
                Optional<Peer> peer = peers.stream()
                        .filter(p -> p.getName().equals(from))
                        .findAny();
                if (peer.isPresent()) {
                    peer.get().stopAllConnections();
                    connections = connections.stream()
                            .filter(c -> !c.getInitiator().getName().equals(from) && !c.getTarget().getName().equals(from))
                            .collect(Collectors.toList());
                } else {
                    throw new ChatException("There is no connection from " + from + "!");
                }
            }
            return message;
        } else {
            throw new ChatException("There is no connection between " + from + " and " + to + "!");
        }
    }
}
