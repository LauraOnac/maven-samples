package com.chat;

import java.io.*;
import java.awt.*;
import java.net.Socket;

/**
 * Created by Laura on 12/11/2017.
 */
public class ChatWindow extends Frame implements Runnable {

    private String from;
    private String to;
    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private TextArea output;
    private TextField input;
    private boolean stop;

    public ChatWindow(String title, String from, String to, Socket socket) {
        super(title);
        this.from = from;
        this.to = to;
        this.socket = socket;
        try {
            this.inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            this.outputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stop = false;
        setLayout(new BorderLayout());
        add("Center", output = new TextArea());
        output.setEditable(false);
        add("South", input = new TextField());
        pack();
        show();
        input.requestFocus();
    }

    @Override
    public void run() {
        try {
            while (!stop) {
                String line = inputStream.readUTF();
                output.appendText(to + ": " + line + "\n");
            }
        } catch (IOException ex) {
            /*Peer closed the socket*/
        } finally {
            output.appendText("Connection closed\n");
            input.hide();
            validate();
            try {
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public boolean handleEvent(Event e) {
        if ((e.target == input) && (e.id == Event.ACTION_EVENT)) {
            try {
                output.appendText(from + ": " + e.arg + "\n");
                String message = ConnectionManager.processInput(from, to, (String) e.arg);
                outputStream.writeUTF(message);
                outputStream.flush();
            } catch (ChatException ex) {
                output.appendText(ex.getMessage() + "\n");
            } catch (IOException ex) {
                /*I closed my socket*/
            }
            input.setText("");
            return true;
        } else if ((e.target == this) && (e.id == Event.WINDOW_DESTROY)) {
            stop();
            hide();
            return true;
        }
        return super.handleEvent(e);
    }

    public void stop() {
        stop = true;
        try {
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getTo() {
        return to;
    }
}
