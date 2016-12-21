package client;

import application.*;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CatalogueClient {
    private static final Logger log = Logger.getLogger(CatalogueClient.class.getName());
    private Socket socket;

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    private String host;
    private int port;

    public void connect() {
        try {
            socket = new Socket(host, port);
        } catch (IOException e) {
            log.log(Level.SEVERE, "Failed to connect to server: " + host + " port number: " + port);
        }
    }

    public void sendRequest(String request) {

        try {
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream, true);
            printWriter.println(request);
        } catch (IOException | NullPointerException e) {
            log.log(Level.SEVERE, "Request failed ", e);
        }

    }

    public String waitForResponse() {

        String response = "";
        try {
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            for (String line = bufferedReader.readLine(); !line.equals(""); line = bufferedReader.readLine()) {
                response += line + "\n";
            }
            log.info("Data was received from the server");
        } catch (IOException | NullPointerException e) {
            log.log(Level.SEVERE,"failed to receive a response from the server", e);
        }
        return response;
    }

    public void disconnect() {
        sendRequest("exit");
        try {
            socket.close();
        } catch (IOException | NullPointerException e) {
            log.log(Level.SEVERE,"Failed to close socket: ", e);
        }

    }
}
