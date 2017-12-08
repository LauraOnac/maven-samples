package com.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Laura on 12/6/2017.
 */
public class Peer{

    public static void main(String[] args){

        new Thread( () -> {
            try (ServerSocket socket = new ServerSocket(0)) {
                System.out.println("Listening on port " + socket.getLocalPort());
                while (true) {

                    final Socket newSocket = socket.accept();
                    new Thread(() -> {
                        try (
                                PrintWriter out = new PrintWriter(newSocket.getOutputStream(), true);
                                BufferedReader in = new BufferedReader(new InputStreamReader(newSocket.getInputStream()))
                        ) {
                            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
                            String fromMe;
                            String fromPeer;

                            while ((fromPeer = in.readLine()) != null) {

                                System.out.println("Peer: " + fromPeer);
                                if (fromPeer.equals("Bye."))
                                    break;

                                fromMe = stdIn.readLine();
                                if (fromMe != null) {
                                    //System.out.println("Me: " + fromMe);
                                    out.println(fromMe);
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread( () -> {
            String host = "localhost";
            int portNumber = 50538;

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
        }).start();
    }
}
