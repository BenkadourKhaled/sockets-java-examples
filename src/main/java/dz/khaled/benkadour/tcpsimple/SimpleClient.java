package dz.khaled.benkadour.tcpsimple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleClient {

    public static void main(String[] args) throws IOException {

        try {
            // Se connecter au serveur sur localhost:8080
            Socket socket = new Socket("localhost", 8080);
            System.out.println("Connecté au serveur");

            // Obtenir les flux d'entrée/sortie
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Envoyer un message
            out.println("Bonjour du client!");
            System.out.println("Message envoyé au serveur");

            // Recevoir la réponse
            String response = in.readLine();
            System.out.println("Réponse du serveur: " + response);

            // Fermer les ressources
            in.close();
            out.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
