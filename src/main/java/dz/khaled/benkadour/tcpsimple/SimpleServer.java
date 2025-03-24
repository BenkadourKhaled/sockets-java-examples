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
            // Créer un serveur sur le port 8080
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Serveur démarré sur le port 8080");

            // Attendre la connexion d'un client
            System.out.println("En attente de connexion client...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connecté: " + clientSocket.getInetAddress());

            // Obtenir les flux d'entrée/sortie
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Lire un message du client
            String message = in.readLine();
            System.out.println("Message reçu: " + message);

            // Envoyer une réponse
            out.println("Message reçu par le serveur : " + message);

            // Fermer les ressources
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}