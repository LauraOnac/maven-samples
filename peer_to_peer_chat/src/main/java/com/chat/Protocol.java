package com.chat;

/**
 * Created by Laura on 12/12/2017.
 */
public class Protocol {

    private State state;
    private String initiator;
    private String target;

    public Protocol(String initiator, String target) {
        this.state = State.UNINITIALIZED;
        this.initiator = initiator;
        this.target = target;
    }

    public String processInput(String input, String me) {
        if (me.equals(initiator) && input.equals("!hello " + this.target) && this.state.equals(State.UNINITIALIZED)) {
            this.state = State.INITIALIZED;
        } else if (me.equals(target) && ("!ack").equals(input) && this.state.equals(State.INITIALIZED)) {
            this.state = State.ACKNOWLEDGED;
        } else if (("!bye").equals(input) && this.state.equals(State.ACKNOWLEDGED)) {
            this.state = State.TERMINATED;
        } else if (("!byebye").equals(input) && this.state.equals(State.ACKNOWLEDGED)) {
            this.state = State.TERMINATED_ALL;
        } else if (!this.state.equals(State.ACKNOWLEDGED)) {
            this.state = State.BROKEN;
        }
        return input;
    }

    public State getState() {
        return state;
    }
}
