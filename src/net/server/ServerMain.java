package net.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

    public static final int PORT = 22828;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            while (true) {
                System.out.println("Waiting clients");
                Socket firstClient = serverSocket.accept();
                System.out.println("Found first client");
                Socket secondClient = serverSocket.accept();
                System.out.println("Found second client");
                System.out.println("Starting game.");
                new Thread(new ServerSocketThread(firstClient, secondClient)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
