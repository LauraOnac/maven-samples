package com.chat;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Laura on 12/8/2017.
 */
public class ConnectionManager {

    private Executor executor;
    private String host;

    public ConnectionManager(){
        this.executor = Executors.newFixedThreadPool(4);
        this.host = "localhost";
    }

    public void addPeer(Peer peer){
        executor.execute(peer);
    }

    public void connect(Peer peer1, Peer peer2){
        try {
            Socket s = new Socket(host, peer1.getPort());
            new ChatWindow(peer2.getName() + " to " + peer1.getName(), peer2.getName(), peer1.getName(), s.getInputStream(), s.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
