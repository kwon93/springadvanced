package hello.springadvanced.trace.strategy;

import hello.springadvanced.trace.strategy.code.strategy.ContextV1;
import hello.springadvanced.trace.strategy.code.strategy.ContextV2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    @Test
    void contextV2() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(()-> log.info("businessLogic1 실행"));
        contextV2.execute(()-> log.info("businessLogic2 실행"));
    }



}
