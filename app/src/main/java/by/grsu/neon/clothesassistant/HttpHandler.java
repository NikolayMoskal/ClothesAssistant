package by.grsu.neon.clothesassistant;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Performs the HTTP requests during POST method
 */
public class HttpHandler {
    /**
     * Makes the HTTP POST request to selected host
     *
     * @param reqUrl the URL address of remote host
     * @param params the POST parameters, e.g. <i>param1=1&param2=2&param3=3</i> etc.
     * @return the string response of the remote host
     * @throws IOException when an error occurred because of:<br>
     *                     <ol>
     *                     <li>invalid URL</li>
     *                     <li>while trying to connect</li>
     *                     <li>while trying to read the output stream</li>
     *                     <li>the response stream cannot be converted to string</li>
     *                     </ol>
     */
    public static String call(String reqUrl, String params) throws IOException {
        HttpURLConnection connection = prepareConnection(reqUrl, params);
        connection.connect();
        // read the response
        InputStream s1 = connection.getInputStream();
        InputStream stream = new BufferedInputStream(s1);
        return convertStreamToString(stream);
    }

    /**
     * Builds a new connection by URL and params
     *
     * @param regUrl the request URL
     * @param params the POST parameters, e.g. <i>param1=1&param2=2&param3=3</i> etc.
     * @return the new connection object. This object must be opened before using it
     * @throws IOException when an error occurred because of invalid URL or while trying to connect and read the output stream
     */
    private static HttpURLConnection prepareConnection(String regUrl, String params) throws IOException {
        URL url = new URL(regUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Length", String.valueOf(params.length()));
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        DataOutputStream stream = new DataOutputStream(connection.getOutputStream());
        stream.writeBytes(params);
        stream.flush();
        stream.close();
        return connection;
    }

    /**
     * Converts the input stream to string representation
     *
     * @param stream the input stream to convert
     * @return the result string
     * @throws IOException when the line isn't readable
     */
    private static String convertStreamToString(InputStream stream) throws IOException {
        StringBuilder builder = new StringBuilder();
        String line;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
        }
        return builder.toString().replace("\uFEFF", "");
    }
}
