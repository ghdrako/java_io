import java.net.*;
import java.io.*;

public class SingleThreadedBlockingServer {
    public static void main(String[] args) throws IOException {
        int port = 8081;
        Socket s = null;
        InputStream in = null;
        OutputStream out = null;
        try (ServerSocket ss = new ServerSocket(port)) {

            while (true) {
                s = ss.accept();
                in = s.getInputStream();
                out = s.getOutputStream();
                int data;
                while ((data = in.read()) != -1) {
                    out.write(transmogrify(data));
                }
            }
        } catch (IOException e) {
            System.err.println("Problem with create socket");
        } finally {
            out.close();
            in.close();
            s.close();
        }

    }

    public static int transmogrify(int data) {
        return Character.isLetter(data) ? data ^ ' ' : data;
    }

}