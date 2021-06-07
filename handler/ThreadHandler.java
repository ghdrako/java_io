package handler;

public class ThreadHandler<S> extends UnchackedIOExceptionConverterHandler<S> {

    public ThreadHandler(Handler<S> other) {
        super(other);
        // TODO Auto-generated constructor stub
    }

    public void handle(S s) {
        new Thread(() -> super.handle(s)).start();
    }

}
