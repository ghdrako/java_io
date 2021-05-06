import java.net.*;
import java.io.*;

public class SingleThreadedBlockingServer {
    public static void main(String[] args) throws IOException {
        int port = 8081;
        ServerSocket ss = new ServerSocket(port);
        while (true) {
            Socket s = ss.accept();
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();
            int data;
            while ((data = in.read()) != -1) {
                out.write(transmogrify(data));
            }
            out.close();
            in.close();
            s.close();
        }
    }

    public static int transmogrify(int data) {
        return Character.isLetter(data) ? data ^ ' ' : data;
    }

}