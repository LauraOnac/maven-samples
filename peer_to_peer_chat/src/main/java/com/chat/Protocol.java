package com.chat;

/**
 * Created by Laura on 12/12/2017.
 */
public class Protocol {

    private enum State {UNINITIALIZED, INITIALIZED, ACKNOWLEDGED, TERMINATED}
    private State state;
    private String initiator;
    private String target;

    public Protocol(String initiator, String target){
        this.state = State.UNINITIALIZED;
        this.initiator = initiator;
        this.target = target;
    }

    public String processInput(String input, String me){
        if (me.equals(initiator) && input.equals("!hello " + this.target) && this.state.equals(State.UNINITIALIZED)) {
            this.state = State.INITIALIZED;
        }
        else if (me.equals(target) && input.equals("!ack") && this.state.equals(State.INITIALIZED)) {
            System.out.println("Here");
            this.state = State.ACKNOWLEDGED;
        }
        else if (input.equals("!bye") && this.state.equals(State.ACKNOWLEDGED)) {
            this.state = State.TERMINATED;
        }
        else if (!this.state.equals(State.ACKNOWLEDGED)){
            throw new ChatException("The protocol was broken!");
        }
        return input;
    }

}
