package com.chat;

import java.net.*;
import java.io.*;
import java.awt.*;

/**
 * Created by Laura on 12/11/2017.
 */
public class ChatWindow extends Frame implements Runnable{

    protected DataInputStream i;
    protected DataOutputStream o;
    protected TextArea output;
    protected TextField input;
    protected Thread listener;

    public ChatWindow (String title, InputStream i, OutputStream o) {
        super (title);
        this.i = new DataInputStream (new BufferedInputStream (i));
        this.o = new DataOutputStream (new BufferedOutputStream (o));
        setLayout (new BorderLayout ());
        add ("Center", output = new TextArea ());
        output.setEditable (false);
        add ("South", input = new TextField ());
        pack ();
        show ();
        input.requestFocus ();
        listener = new Thread (this);
        listener.start ();
    }

    @Override
    public void run () {
        try {
            while (true) {
                String line = i.readUTF ();
                output.appendText ("Peer: " + line + "\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace ();
        } finally {
            listener = null;
            input.hide ();
            validate ();
            try {
                o.close ();
            } catch (IOException ex) {
                ex.printStackTrace ();
            }
        }
    }

    @Override
    public boolean handleEvent (Event e) {
        if ((e.target == input) && (e.id == Event.ACTION_EVENT)) {
            try {
                output.appendText("Me: " + e.arg + "\n");
                o.writeUTF ((String) e.arg);
                o.flush ();
            } catch (IOException ex) {
                ex.printStackTrace();
                listener.stop ();
            }
            input.setText ("");
            return true;
        } else if ((e.target == this) && (e.id == Event.WINDOW_DESTROY)) {
            if (listener != null)
                listener.stop ();
            hide ();
            return true;
        }
        return super.handleEvent (e);
    }

    public static void main (String args[]) throws IOException {
        Socket s = new Socket ("localhost", 52320);
        new ChatWindow ("Chat",
                s.getInputStream (), s.getOutputStream ());
    }
}
