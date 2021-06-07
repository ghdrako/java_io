package handler;

import java.io.*;

public interface Handler<S> {
    void handle(S s) throws IOException;

}
