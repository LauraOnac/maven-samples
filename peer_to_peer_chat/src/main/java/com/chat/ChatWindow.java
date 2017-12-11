package com.chat;

import java.io.*;
import java.awt.*;

/**
 * Created by Laura on 12/11/2017.
 */
public class ChatWindow extends Frame implements Runnable{

    private String from;
    private String to;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private TextArea output;
    private TextField input;
    private Thread listener;
    private volatile boolean stop;

    public ChatWindow (String title, String from, String to, InputStream inputStream, OutputStream outputStream) {
        super (title);
        this.from = from;
        this.to = to;
        this.inputStream = new DataInputStream (new BufferedInputStream (inputStream));
        this.outputStream = new DataOutputStream (new BufferedOutputStream (outputStream));
        this.stop = false;
        setLayout (new BorderLayout ());
        add ("Center", output = new TextArea ());
        output.setEditable (false);
        add ("South", input = new TextField ());
        pack ();
        show ();
        input.requestFocus ();
        listener = new Thread (this);
        listener.start();
    }

    @Override
    public void run () {
        try {
            while (!stop) {
                String line = inputStream.readUTF ();
                output.appendText (to + ": " + line + "\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace ();
        } finally {
            listener = null;
            input.hide ();
            validate ();
            try {
                outputStream.close ();
            } catch (IOException ex) {
                ex.printStackTrace ();
            }
        }
    }

    @Override
    public boolean handleEvent (Event e) {
        if ((e.target == input) && (e.id == Event.ACTION_EVENT)) {
            try {
                output.appendText(from + ": " + e.arg + "\n");
                outputStream.writeUTF ((String) e.arg);
                outputStream.flush ();
                input.setText("");
            } catch (IOException ex) {
                ex.printStackTrace();
                listener.stop ();
            }
            return true;
        } else if ((e.target == this) && (e.id == Event.WINDOW_DESTROY)) {
            if (listener != null)
                listener.stop ();
            hide ();
            return true;
        }
        return super.handleEvent (e);
    }

    public void stop(){
        stop = true;
    }
}
