import java.net.*;
import java.io.*;

public class MultipleThreadedBlockingServer {
    public static void main(String[] args) throws IOException {
        int port = 8081;
        ServerSocket ss = new ServerSocket(port);

        while (true) {
            Socket s = ss.accept();
            handle(s);

        }

    }

    public static void handle(Socket s) throws IOException {
        new Thread(() -> {
            System.out.println("Connected to" + s);
            try (s; InputStream in = s.getInputStream(); OutputStream out = s.getOutputStream()) {
                int data;
                while ((data = in.read()) != -1) {
                    out.write(transmogrify(data));
                }
            } catch (IOException ex) {
                throw new UncheckedIOException(ex);
            } finally {
                System.out.println("Disconnected from" + s);

            }
        }).start();
    }

    public static int transmogrify(int data) {
        return Character.isLetter(data) ? data ^ ' ' : data;
    }

}