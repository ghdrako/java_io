package handler;

import java.io.*;

public class UnchackedIOExceptionConverterHandler<S> extends DecoratedHandler<S> {

    public UnchackedIOExceptionConverterHandler(Handler<S> other) {
        super(other);
    }

    public void handle(S s) {
        try {
            super.handle(s);
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }
}
