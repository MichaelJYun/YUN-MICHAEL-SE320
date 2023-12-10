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
 * This program creates a server that calculates the BMI (Body Mass Index) based on weight and height received from a client.
 * It demonstrates the use of Java sockets, input/output streams, and a basic Swing GUI.
 **/

public class Server extends JFrame {
    private JTextArea jta = new JTextArea();

    public static void main(String[] args) {
        new Server();
    }

    public Server() {
        // Place text area on the frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(new JScrollPane(jta), BorderLayout.CENTER);

        setTitle("Server");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            jta.append("BMI Server started at " + new Date() + '\n');

            while (true) {
                Socket socket = serverSocket.accept();
                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

                // Receive weight and height from client
                double weight = inputFromClient.readDouble();
                double height = inputFromClient.readDouble();

                // Compute BMI, formula from Q1
                double bmi = weight / (height * height);

                // Send BMI back to the client
                outputToClient.writeUTF("BMI is: " + bmi);

                // Display the result in text area
                jta.append("Received weight: " + weight + " and height: " + height + '\n');
                jta.append("Calculated BMI: " + bmi + '\n');
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
