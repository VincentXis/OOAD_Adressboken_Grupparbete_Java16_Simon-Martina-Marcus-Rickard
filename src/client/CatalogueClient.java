package client;

import java.io.*;
import java.net.Socket;

public class CatalogueClient {

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
            e.printStackTrace();
        }
    }

    public void sendRequest(String request) {

        try {
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream, true);
            printWriter.println(request);
        } catch (IOException e) {
            e.printStackTrace();
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    public void disconnect() {
        sendRequest("exit");
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
