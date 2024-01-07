package hello.springadvanced.trace.callback;

import hello.springadvanced.trace.TraceStatus;
import hello.springadvanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TraceTemplate {

    private final LogTrace trace;
    public <T> T execute(String message, TraceCallback<T> callback){
        TraceStatus status = null;



        try {
            status = trace.begin(message);

            T result = callback.call();

            trace.end(status);
            return result;
        }catch (Exception e){
            trace.exception(status, e);
            throw e;
        }
    }
}
