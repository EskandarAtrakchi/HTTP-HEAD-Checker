import java.io.IOException;// import the IOException class to handle exceptions
import java.net.HttpURLConnection; // import the HttpURLConnection class to make HTTP requests
import java.net.MalformedURLException; // import the MalformedURLException class to handle exceptions
import java.net.URL; // import the URL class to work with URLs
import javax.swing.JOptionPane; // import the JOptionPane class to create dialog boxes

public class HeadRequestApp {
    public static void main(String[] args) {
        // Default URL
        // String defaultUrl = "http://nginx.org/"; // original code
        String defaultUrl = "http://nginx.org/";

        
        /**
        Show a dialog to prompt for the URL to do the following actions:
        If the user leaves the input blank, use the default URL
        If the user cancels the dialog, exit the program
        If the user provides an invalid URL, show an error message
        If the connection fails, show an error message
        If the connection is successful, show a success message with the response code and message
         */
        String userInput = JOptionPane.showInputDialog(
            null,
            "Enter a URL (leave blank to use the default: " + defaultUrl + ")",
            "HTTP HEAD Request",
            JOptionPane.INFORMATION_MESSAGE
        );

        // Use default URL if no input is provided
        String urlString = (userInput == null || userInput.trim().isEmpty()) ? defaultUrl : userInput.trim();// better code readability than below commented code 

        // if (userInput == null || userInput.trim().isEmpty()) {
        //     urlString = defaultUrl;
        // } else {
        //     urlString = userInput.trim();
        // }

        // Inform the user of the URL being used
        JOptionPane.showMessageDialog(
            null,
            "Using URL: " + urlString,
            "URL Confirmation",
            JOptionPane.INFORMATION_MESSAGE
        );

        try {
            // Parse the URL
            URL url = new URL(urlString);

            // Open the connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method to HEAD
            connection.setRequestMethod("HEAD");

            // Set timeout (5 seconds)
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            // Connect and retrieve response
            int responseCode = connection.getResponseCode();
            String responseMessage = connection.getResponseMessage();

            // Display the response to the user
            JOptionPane.showMessageDialog(
                null,
                "Connected to: " + urlString + "\nResponse Code: " + responseCode + "\nResponse Message: " + responseMessage,
                "Connection Successful",
                JOptionPane.INFORMATION_MESSAGE
            );
        } catch (MalformedURLException e) {
            // Inform the user of the invalid URL
            JOptionPane.showMessageDialog(
                null,
                "Invalid URL: " + urlString,
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        } catch (IOException e) {
            // Handles connection fails and timeouts
            JOptionPane.showMessageDialog(
                null,
                "Connection failed: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
