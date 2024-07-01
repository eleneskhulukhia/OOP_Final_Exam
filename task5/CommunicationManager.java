package finalexam.task5;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CommunicationManager {

    private String endpoint;

    public CommunicationManager(String endpoint) {
        this.endpoint = endpoint;
    }

    public String sendUserMessage(String message) {
        try {
            URL url = new URL(endpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set connection properties
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            // Send message
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = message.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Read response
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Response handling (if needed)
                return "Message sent successfully";
            } else {
                // Handle error response (if needed)
                return "Failed to send message. Response code: " + responseCode;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to send message: " + e.getMessage();
        }
    }
}
