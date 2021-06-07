package server;

import java.net.*;
import handler.*;
import java.io.*;

public class SingleThreadedBlockingServer {
    public static void main(String[] args) throws IOException {
        int port = 8081;
        ServerSocket ss = new ServerSocket(port);
        Handler<Socket> handler = new PrintHandler<>(new TransmogrifyHandler());

        while (true) {
            Socket s = ss.accept();
            handler.handle(s);

        }

    }

}