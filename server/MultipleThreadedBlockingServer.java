package server;

import java.net.*;
import handler.*;
import java.io.*;

public class MultipleThreadedBlockingServer {
    public static void main(String[] args) throws IOException {
        int port = 8081;
        ServerSocket ss = new ServerSocket(port);
        ThreadHandler<Socket> handler = new ThreadHandler<>(new PrintHandler<>(new TransmogrifyHandler()));
        while (true) {
            Socket s = ss.accept();
            handler.handle(s);
        }
    }

}