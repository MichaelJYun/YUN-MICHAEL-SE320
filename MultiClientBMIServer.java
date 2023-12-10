import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

/**
 * Author: Michael Yun
 * Based on initial code structure provided by Dr. Akbas' lecture slides.
 * Assignment: Final Assignment
 * 
 * This program creates a multi-client server that calculates the BMI (Body Mass Index) based on weight and height received from clients.
 * It demonstrates the use of Java sockets, multi-threading, input/output streams, and a basic Swing GUI for concurrent client handling.
 * Each client connection is managed in a separate thread, allowing the server to process multiple client requests simultaneously.
 */

public class MultiClientBMIServer extends JFrame {
    private JTextArea jta = new JTextArea();

    public static void main(String[] args) {
        new MultiClientBMIServer();
    }

    public MultiClientBMIServer() {

        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            jta.append("Multi-Client BMI Server started at " + new Date() + '\n');

            while (true) {
                Socket socket = serverSocket.accept();
                // Create a new Thread for each client
                ClientHandler clientThread = new ClientHandler(socket);
                new Thread(clientThread).start();
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    // ClientHandler class handles new client connections
    class ClientHandler implements Runnable {
        private Socket socket;
        
        // Constructor
        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

                // Process client
                while (true) {
                    double weight = inputFromClient.readDouble();
                    double height = inputFromClient.readDouble();

                    // Compute BMI
                    double bmi = weight / (height * height);

                    // Send BMI back to the client 
                    outputToClient.writeUTF("BMI is: " + bmi);

                    // Update the server's GUI 
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            jta.append("Received weight: " + weight + " and height: " + height + '\n');
                            jta.append("Calculated BMI: " + bmi + '\n');
                        }
                    });
                }
            } catch (IOException ex) {
                System.err.println("Client disconnected: " + ex.getMessage());
            }
        }
    }
}
