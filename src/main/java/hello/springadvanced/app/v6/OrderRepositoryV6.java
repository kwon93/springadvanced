package hello.springadvanced.app.v6;

import hello.springadvanced.trace.callback.TraceTemplate;
import hello.springadvanced.trace.logtrace.LogTrace;
import hello.springadvanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryV6 {

    private final TraceTemplate traceTemplate;

    public OrderRepositoryV6(TraceTemplate traceTemplate, LogTrace logTrace) {
        this.traceTemplate = new TraceTemplate(logTrace);
    }

    public void save(String itemId){

        traceTemplate.execute("OrderRepository.save()",()->{
            if (itemId.equals("ex")){
                throw new IllegalStateException("에외 발생!");
            }
            sleep(1000);
            return null;
        });
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
