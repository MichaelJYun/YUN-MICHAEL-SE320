import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Author: Michael Yun
 * Based on initial code structure provided by Dr. Akbas' lecture slides.
 * Assignment: Final Assignment
 * 
 * This program creates a client application that interacts with a server to calculate the BMI (Body Mass Index) based on weight and height.
 * It demonstrates the use of Java sockets for network communication, input/output streams for data exchange, and a basic Swing GUI for user interaction.
 * The client sends weight and height data to the server and receives the calculated BMI in return, displaying the results in a user-friendly interface.
 */

public class Client extends JFrame implements ActionListener {
    
    private JTextField jtfWeight = new JTextField();
    private JTextField jtfHeight = new JTextField();
    private JTextArea jta = new JTextArea();

    // IO streams
    private DataOutputStream outputToServer;
    private DataInputStream inputFromServer;

    public static void main(String[] args) {
        new Client();
    }

    public Client() {
        // Panel p to hold the label and text field
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 2));
        p.add(new JLabel("Enter weight in kilograms: "));
        p.add(jtfWeight);
        p.add(new JLabel("Enter height in meters: "));
        p.add(jtfHeight);

        setLayout(new BorderLayout());
        add(p, BorderLayout.NORTH);
        add(new JScrollPane(jta), BorderLayout.CENTER);

        jtfWeight.setHorizontalAlignment(JTextField.RIGHT);
        jtfHeight.setHorizontalAlignment(JTextField.RIGHT);

        jtfWeight.addActionListener(this);
        jtfHeight.addActionListener(this);


        setTitle("Client");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        try {
            
            Socket socket = new Socket("localhost", 8000);

            inputFromServer = new DataInputStream(socket.getInputStream());
            outputToServer = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            jta.append(ex.toString() + '\n');
        }
    }

    public void actionPerformed(ActionEvent e) {
        try {
            // Get weight and height from text field
            double weight = Double.parseDouble(jtfWeight.getText().trim());
            double height = Double.parseDouble(jtfHeight.getText().trim());

            // Send values to server
            outputToServer.writeDouble(weight);
            outputToServer.writeDouble(height);

            // Get bmi from server
            String bmi = inputFromServer.readUTF();

            // Display to text area
            jta.append("Weight: " + weight + " Height: " + height + "\n");
            jta.append(bmi + "\n");
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}

