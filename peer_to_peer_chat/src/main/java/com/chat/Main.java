package com.chat;

/**
 * Created by Laura on 12/11/2017.
 */
public class Main {

    public static void main(String[] args) {

        ConnectionManager connectionManager = new ConnectionManager();

        Peer peer1 = new Peer("George");
        Peer peer2 = new Peer("Alan");
        Peer peer3 = new Peer("Alice");

        connectionManager.addPeer(peer1);
        connectionManager.addPeer(peer2);
        connectionManager.addPeer(peer3);

        connectionManager.connect(peer1, peer2);
        //connectionManager.connect(peer3, peer1);
    }
}
