package hello.springadvanced.trace.strategy;

import hello.springadvanced.trace.strategy.code.template.Callback;
import hello.springadvanced.trace.strategy.code.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallBackTest {

    /**
     * template Callback pattern
     */
    @Test
    void callBackV1() {
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(new Callback() {
            @Override
            public void call() {
                log.info("Business Logic 1 실행");
            }
        });

        template.execute(new Callback() {
            @Override
            public void call() {
                log.info("Business Logic 2 실행");
            }
        });
    }

    /**
     * TemplateCallback Lambda
     */
    @Test
    void lambda() {
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(() -> log.info("BusinessLogic 1 실행"));
        template.execute(() -> log.info("BusinessLogic 2 실행"));
    }
}
