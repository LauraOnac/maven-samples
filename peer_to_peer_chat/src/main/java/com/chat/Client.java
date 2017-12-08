package com.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Laura on 12/6/2017.
 */
public class Client {

    public static void main(String [ ] args){

        String host = "localhost";
        int portNumber = 49856;

        try (
                Socket socket = new Socket(host, portNumber);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String fromPeer;
            String fromMe;

            while ((fromMe = stdIn.readLine()) != null) {

                //System.out.println("Me: " + fromMe);
                out.println(fromMe);

                fromPeer = in.readLine();
                if (fromPeer != null) {
                    System.out.println("Peer: " + fromPeer);
                    if (fromPeer.equals("Bye."))
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
