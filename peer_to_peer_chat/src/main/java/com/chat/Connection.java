package com.chat;

/**
 * Created by Laura on 12/12/2017.
 */
public class Connection {

    private Peer initiator;
    private Peer target;
    private Protocol protocol;

    public Connection(Peer initiator, Peer target) {
        this.initiator = initiator;
        this.target = target;
        this.protocol = new Protocol(initiator.getName(), target.getName());
    }

    public Peer getInitiator() {
        return initiator;
    }

    public Peer getTarget() {
        return target;
    }

    public Protocol getProtocol() {
        return protocol;
    }
}
