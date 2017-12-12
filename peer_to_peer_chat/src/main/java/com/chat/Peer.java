package com.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Laura on 12/6/2017.
 */
public class Peer implements Runnable {

    private String name;
    private ServerSocket socket;
    private Executor executor;
    private List<ChatWindow> chatWindows;
    private boolean stop;

    public Peer(String name) {
        this.name = name;
        this.stop = false;
        this.executor = Executors.newFixedThreadPool(4);
        this.chatWindows = new ArrayList<>();
        try {
            this.socket = new ServerSocket(0);
        } catch (IOException ex) {
            throw new ChatException(ex.getMessage());
        }
    }

    public void addChat(ChatWindow chatWindow) {
        executor.execute(chatWindow);
        chatWindows.add(chatWindow);
    }

    @Override
    public void run() {
        try {
            while (!stop) {
                final Socket newSocket = socket.accept();

                BufferedReader in = new BufferedReader(new InputStreamReader(newSocket.getInputStream()));
                String peer = in.readLine();

                ChatWindow chatWindow = new ChatWindow(name + " to " + peer, name, peer, newSocket);
                addChat(chatWindow);
            }
        } catch (IOException ex) {
            /*I closed my own socket*/
        }
    }

    public String getName() {
        return name;
    }

    public int getPort() {
        return socket.getLocalPort();
    }

    public void stopAllConnections() {
        stop = true;
        for (ChatWindow chatWindow : chatWindows) {
            chatWindow.stop();
        }
        try {
            socket.close();
        } catch (IOException ex) {
            throw new ChatException(name + " cannot close their socket!");
        }
    }

    public void stopConnectionTo(String peer) {
        Optional<ChatWindow> chatWindow = chatWindows.stream()
                .filter(cw -> cw.getTo().equals(peer))
                .findAny();
        if (chatWindow.isPresent()) {
            chatWindow.get().stop();
        } else {
            throw new ChatException("There is no connection between " + name + " and " + peer + "!");
        }
    }
}
