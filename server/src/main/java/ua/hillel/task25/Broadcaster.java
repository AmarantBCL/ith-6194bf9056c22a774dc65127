package ua.hillel.task25;

import java.util.List;

public class Broadcaster {
    public void sendAll(List<ClientHandler> activeClients, ClientHandler clientHandler, String message) {
        for (ClientHandler client : activeClients) {
            if (client != clientHandler) {
                client.sendMessage(message);
            }
        }
    }
}
