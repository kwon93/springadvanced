package hello.springadvanced.trace.callback;

@FunctionalInterface
public interface TraceCallback<T> {
    T call();
}
