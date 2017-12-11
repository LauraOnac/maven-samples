package com.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Laura on 12/6/2017.
 */
public class Peer implements Runnable{

    private String name;
    private ServerSocket socket;
    private volatile boolean stop;

    public Peer(String name){
        this.name = name;
        this.stop = false;
        try {
            this.socket = new ServerSocket(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        try {
            while(!stop) {
                final Socket newSocket = socket.accept();
                new ChatWindow (name + " to " + "Peer", name, "Peer", newSocket.getInputStream(), newSocket.getOutputStream());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName(){
        return name;
    }

    public int getPort(){
        return socket.getLocalPort();
    }

    public void stop(){
        stop = true;
    }
}
