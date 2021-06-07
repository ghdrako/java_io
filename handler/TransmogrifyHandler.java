package handler;

import java.net.*;
import java.io.*;
import util.*;

public class TransmogrifyHandler implements Handler<Socket> {
    public void handle(Socket s) throws IOException {
        try (s; InputStream in = s.getInputStream(); OutputStream out = s.getOutputStream()) {
            int data;
            while ((data = in.read()) != -1) {
                out.write(Util.transmogrify(data));
            }
        }
    }

}
