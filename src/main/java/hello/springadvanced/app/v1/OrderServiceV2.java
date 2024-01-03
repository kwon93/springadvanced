package hello.springadvanced.app.v1;

import hello.springadvanced.trace.TraceId;
import hello.springadvanced.trace.TraceStatus;
import hello.springadvanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepositoryV2;
    private final HelloTraceV2 trace;

    public void orderItem(String itemId, TraceId traceId){

        TraceStatus status = null;

        try{
            status = trace.beginSync(traceId,"OrderService.orderItem()");
            orderRepositoryV2.save(itemId, status.getTraceId());
            trace.end(status);

        }catch (Exception e){
            trace.exception(status, e);
            throw e;
        }
    }
}
