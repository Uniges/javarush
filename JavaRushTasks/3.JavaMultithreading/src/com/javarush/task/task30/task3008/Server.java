package com.javarush.task.task30.task3008;

import java.io.Console;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
            Connection connect = entry.getValue();
            try {
                connect.send(message);
            } catch (IOException e) {
                String name = entry.getKey();
                ConsoleHelper.writeMessage(name+", сообщение не было отправлено. Ошибка.");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(ConsoleHelper.readInt());
            ConsoleHelper.writeMessage("Сервер запущен.");
            while (true) {
                new Handler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage(e.getMessage());
            serverSocket.close();
        }

    }

    private static class Handler extends Thread {

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установлено соединение с удаленным адресом: "+ socket.getRemoteSocketAddress());
            String name = null;
            try {
                Connection connection = new Connection(socket);
                name = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, name));
                sendListOfUsers(connection, name);
                serverMainLoop(connection, name);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            if (name!=null) {
                connectionMap.remove(name);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, name));
            }
        }

        private Socket socket;
        public Handler(Socket socket) {
            this.socket = socket;
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            Message message;
            while (true) {
                message = connection.receive();
                if (message.getType()==(MessageType.TEXT)) {
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName+": "+message.getData()));
                }
                else {
                    ConsoleHelper.writeMessage("Ошибка: отправленное сообщение не является текстом");
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
                String name = entry.getKey();
                if (!(name.equals(userName))) {
                    connection.send(new Message(MessageType.USER_ADDED, name));
                }
            }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            String name;
            Message message;
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                message = connection.receive();
                if (message.getType().equals(MessageType.USER_NAME)) {
                    name = message.getData();
                    if (!(name.isEmpty()) && !(connectionMap.containsKey(name))) {
                        connectionMap.put(name, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        return name;
                    }
                }
            }
        }
    }
}
