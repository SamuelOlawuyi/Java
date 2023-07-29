import org.example.HttpServer;
        import org.junit.After;
        import org.junit.Before;
        import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import static org.junit.Assert.assertEquals;

public class HttpServerTest {
    private static final int PORT = 8081; // Use a different port for testing

    private HttpServer server;
    private Thread serverThread;

    @Before
    public void setUp() {
        // Start the server in a separate thread
        server = new HttpServer(PORT);
        serverThread = new Thread(() -> server.start());
        serverThread.start();
    }
//
    @After
    public void tearDown() {
        // Stop the server and wait for the server thread to finish
        server.stop();
        try {
            serverThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
//
    @Test
    public void testHomePage() throws IOException {
        // Send a GET request to the home page '/'
        String response = sendHttpRequest("GET / HTTP/1.1\r\n\r\n");

        // Check the response contains the expected content
        String expectedResponse = "HTTP/1.1 200 OK\r\nContent-Type: text/html\r\nContent-Length: 39\r\n\r\n<html><body><h1>Hello, World!</h1></body></html>";
        assertEquals(expectedResponse, response);
    }

//    private String sendHttpRequest(String s) {
//        return s;
//    }

    @Test
    public void testNotFoundPage() throws IOException {
        // Send a GET request to a non-existent page '/nonexistent'
        String response = sendHttpRequest("GET /nonexistent HTTP/1.1\r\n\r\n");
//
        // Check the response contains the expected content
        String expectedResponse = "HTTP/1.1 404 Not Found\r\nContent-Type: text/plain\r\nContent-Length: 12\r\n\r\n404 Not Found";
        assertEquals(expectedResponse, response);
    }
//
    private String sendHttpRequest(String httpRequest) throws IOException {
        try (Socket socket = new Socket("localhost", PORT)) {
            socket.getOutputStream().write(httpRequest.getBytes());

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line).append("\r\n");
            }
            return response.toString();
        }
    }
}