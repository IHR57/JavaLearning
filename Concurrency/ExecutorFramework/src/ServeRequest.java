import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeRequest {

    private static final String DOCUMENT = "" +
            "<html>" +
            "    <head>" +
            "        <title>Single Threaded Server</title>" +
            "    </head>" +
            "    <body>" +
            "        <p>It Works!</p>" +
            "    </body>" +
            "</html>";

    private static final String HEADER =
            "HTTP/1.1 200 OK\r\n"
            + "Content-Type: text/html; charset=UTF-8\r\n"
            + "Content-Length: " + DOCUMENT.length() + "\r\n\r\n";

    public void serveRequest(Socket connection) {
        System.out.println("New Connection request from " + connection.toString());
        try (OutputStream os = connection.getOutputStream();
            PrintWriter out = new PrintWriter(os)) {
            out.write(HEADER);
            out.write(DOCUMENT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
