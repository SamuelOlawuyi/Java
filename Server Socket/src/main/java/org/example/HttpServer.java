package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    public HttpServer(int port) {
    }

    public static void main(String[] args) {
        int port = 8180; // Define the port number for the server

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();

                // Start a new thread to handle the client request
                Thread thread = new Thread(() -> handleClientRequest(clientSocket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClientRequest(Socket clientSocket) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {

            // Read the HTTP request
            String request = reader.readLine();
            System.out.println("Received request: " + request);

            // Parse the request
            String[] requestParts = request.split(" ");
            String method = requestParts[0];
            String path = requestParts[1];

            // Prepare the HTTP response
            String response;
            if (method.equals("GET") && path.equals("/")) {
                String content = "<html><body><h1>Samuel Olawuyi, Software Engineer!</h1><p>Keep leaning, my hands will soon be strong</p></body></html>";
                response = "HTTP/1.1 200 OK\r\n"
                        + "Content-Type: text/html\r\n"
                        + "Content-Length: " + content.length() + "\r\n"
                        + "\r\n"
                        + content;
            } else {
                String content = "404 Not Found";
                response = "HTTP/1.1 404 Not Found\r\n"
                        + "Content-Type: text/plain\r\n"
                        + "Content-Length: " + content.length()
                        + "\r\n" + "\r\n"
                        + content;
            }

            // Send the HTTP response
            writer.write(response);
            writer.flush();
            System.out.println("Sent response:\n" + response);

            // Close the client socket
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
    }

    public void start() {
    }
}