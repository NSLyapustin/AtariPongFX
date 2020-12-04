package net.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerSocketThread implements Runnable {

    private Scanner scannerFromFirstClient;
    private PrintWriter writerToFirstClient;
    private Scanner scannerFromSecondClient;
    private PrintWriter writerToSecondClient;

    public ServerSocketThread(Socket firstClient, Socket secondClient) throws IOException {
        scannerFromFirstClient = new Scanner(firstClient.getInputStream());
        writerToFirstClient = new PrintWriter(firstClient.getOutputStream(), true);

        scannerFromSecondClient = new Scanner(secondClient.getInputStream());
        writerToSecondClient = new PrintWriter(secondClient.getOutputStream(), true);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("lol");
            if (scannerFromFirstClient.hasNext()) {
                String result = scannerFromFirstClient.nextLine();
                System.out.println(result);
                writerToFirstClient.println("from server: Welcome!");
            }

            if (scannerFromSecondClient.hasNext()) {
                String result = scannerFromSecondClient.nextLine();
                System.out.println(result);
                writerToSecondClient.println("from server: Welcome!");
            }
        }
    }
}
