package hello.springadvanced.app.V5;

import hello.springadvanced.trace.TraceStatus;
import hello.springadvanced.trace.logtrace.LogTrace;
import hello.springadvanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV5 {

    private final OrderServiceV5 orderServiceV5;
    private final LogTrace trace;

    @GetMapping("/v5/request")
    public String request(String itemId){
        AbstractTemplate<String> template = new AbstractTemplate<>(trace) {
            @Override
            protected String call() {
                orderServiceV5.orderItem(itemId);
                return "ok";
            }
        };
        return template.excuteMessage("OrderController.request()");
    }
}
