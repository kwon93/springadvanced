package hello.springadvanced.app.v6;

import hello.springadvanced.trace.callback.TraceTemplate;
import hello.springadvanced.trace.logtrace.LogTrace;
import hello.springadvanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV6 {

    private final OrderRepositoryV6 orderRepositoryV6;
    private final TraceTemplate traceTemplate;

    public OrderServiceV6(OrderRepositoryV6 orderRepositoryV6, TraceTemplate traceTemplate, LogTrace logTrace) {
        this.orderRepositoryV6 = orderRepositoryV6;
        this.traceTemplate = new TraceTemplate(logTrace);
    }

    public void orderItem(String itemId){
        traceTemplate.execute("OrderService.OrderItem()", ()-> {
            orderRepositoryV6.save(itemId);
            return null;
        });

    }
}
