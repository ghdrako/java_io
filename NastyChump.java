import java.net.*;
import java.io.*;

public class NastyChump {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket[] socket = new Socket[3000];
        for (int i = 0; i < socket.length; i++) {
            try {
                socket[i] = new Socket("localhost", 8081);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        Thread.sleep(100_000);
    }

}
