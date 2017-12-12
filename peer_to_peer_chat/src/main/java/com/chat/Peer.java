package com.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Laura on 12/6/2017.
 */
public class Peer implements Runnable {

    private String name;
    private ServerSocket socket;
    private Executor executor;
    private volatile boolean stop;

    public Peer(String name) {
        this.name = name;
        this.stop = false;
        this.executor = Executors.newFixedThreadPool(4);
        try {
            this.socket = new ServerSocket(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addChat(ChatWindow chatWindow) {
        executor.execute(chatWindow);
    }

    @Override
    public void run() {
        try {
            while (!stop) {
                final Socket newSocket = socket.accept();

                BufferedReader in = new BufferedReader(new InputStreamReader(newSocket.getInputStream()));
                String peer = in.readLine();

                ChatWindow chatWindow = new ChatWindow(name + " to " + peer, name, peer,
                        newSocket.getInputStream(), newSocket.getOutputStream());
                addChat(chatWindow);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public int getPort() {
        return socket.getLocalPort();
    }

    public void stop() {
        stop = true;
    }
}
