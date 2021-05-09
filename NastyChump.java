import java.net.*;
import java.io.*;

public class NastyChump {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket[] socket = new Socket[3000];
        for (int i = 0; i < socket.length; i++) {
            socket[i] = new Socket("localhost", 8081);

        }
        Thread.sleep(100_000);
    }

}
