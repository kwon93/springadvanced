package hello.springadvanced.app.v6;

import hello.springadvanced.trace.callback.TraceCallback;
import hello.springadvanced.trace.callback.TraceTemplate;
import hello.springadvanced.trace.logtrace.LogTrace;
import hello.springadvanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV6 {

    private final OrderServiceV6 orderServiceV6;
    private final TraceTemplate traceTemplate;

    public OrderControllerV6(OrderServiceV6 orderServiceV6, TraceTemplate traceTemplate, LogTrace trace) {
        this.orderServiceV6 = orderServiceV6;
        this.traceTemplate = new TraceTemplate(trace);
    }

    @GetMapping("/v6/request")
    public String request(String itemId){
        return traceTemplate.execute("OrderController.request()", () ->
        {orderServiceV6.orderItem(itemId); return "ok";});
    }
}
