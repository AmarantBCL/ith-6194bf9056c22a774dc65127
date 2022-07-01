package ua.hillel.task25;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static final int PORT = 9000;

    public Client() {
        System.out.println("Connecting to the server...");
        try (Socket socket = new Socket("localhost", PORT)) {
            System.out.println("You have successfully connected to the server!");
            try (DataInputStream in = new DataInputStream(socket.getInputStream())) {
                new Thread(new Handler(socket)).start();
                while (true) {
                    System.out.println("Message: " + in.readUTF());
                }
            } catch (IOException e) {
                throw new RuntimeException("Disconnected from the server", e);
            }
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong with the connection.", e);
        }
    }
}
