package hello.springadvanced.app.v1;

import hello.springadvanced.trace.TraceStatus;
import hello.springadvanced.trace.hellotrace.HelloTraceV1;
import hello.springadvanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderCotrollerV2 {

    private final OrderServiceV2 orderServiceV2;
    private final HelloTraceV2 trace;

    @GetMapping("/v2/request")
    public String request(String itemId){
        TraceStatus status = null;

        try{
            status = trace.begin("OrderController.request()");
            orderServiceV2.orderItem(itemId, status.getTraceId());
            trace.end(status);

            return "ok";
        }catch (Exception e){
            trace.exception(status, e);
            throw e;
        }
    }
}
