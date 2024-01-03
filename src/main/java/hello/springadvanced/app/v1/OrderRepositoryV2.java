package hello.springadvanced.app.v1;

import hello.springadvanced.trace.TraceId;
import hello.springadvanced.trace.TraceStatus;
import hello.springadvanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {

    private final HelloTraceV2 trace;

    public void save(String itemId, TraceId traceId){

        TraceStatus status = null;

        try{
            status = trace.beginSync(traceId,"OrderRepository.save()");

            if (itemId.equals("ex")){
                throw new IllegalStateException("예외 발생");
            }

            sleep(1000);

            trace.end(status);

        }catch (Exception e){
            trace.exception(status, e);
            throw e;
        }


    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
