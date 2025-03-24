package dz.khaled.benkadour.tcpsimple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleClient {

    public static void main(String[] args) throws IOException {

        try {
            Socket socket = new Socket("localhost", 8080);
            System.out.println("Connect to the server");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Hello of Customer");
            System.out.println("Message sender to server");

            String response = in.readLine();
            System.out.println("Server response: " + response);

            in.close();
            out.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
