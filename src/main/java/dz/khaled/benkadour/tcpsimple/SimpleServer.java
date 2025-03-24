package dz.khaled.benkadour.tcpsimple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server start in 8080 Port");

            System.out.println("Waiting for customer connection...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connect : " + clientSocket.getInetAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String message = in.readLine();
            System.out.println("Message received: " + message);

            out.println("Message received By the server : " + message);

            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}