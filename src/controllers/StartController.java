package controllers;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class StartController {

    private Scanner scanner;
    private PrintWriter writer;

    public void startGame(ActionEvent actionEvent) {
        try {
            Socket socket = new Socket("localhost", 22828);

            scanner = new Scanner(socket.getInputStream());
            writer = new PrintWriter(socket.getOutputStream(), true);

            writer.println("Connected!");
            while(true) {
                Thread.sleep(10);
                if (scanner.hasNextLine()) {
                    System.out.println("From server: " + scanner.nextLine());
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
