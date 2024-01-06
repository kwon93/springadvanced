package hello.springadvanced.trace.strategy;

import hello.springadvanced.trace.strategy.code.strategy.ContextV1;
import hello.springadvanced.trace.strategy.code.strategy.Strategy;
import hello.springadvanced.trace.strategy.code.strategy.StrategyLogic1;
import hello.springadvanced.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

    @Test
    void contextV0() {
        logic1();
        logic2();
    }

    @Test
    void contextV1() {
        ContextV1 contextV1 = new ContextV1(() -> log.info("BusinessLogic1 실행"));
        contextV1.execute();

        ContextV1 contextV2 = new ContextV1(() -> log.info("BusinessLogic2 실행"));
        contextV2.execute();
    }

    private void logic1(){
        long startTime = System.currentTimeMillis();
        log.info("BusinessLogic1 실행");

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;

        log.info("result Time = {}", resultTime);
    }

    private void logic2(){
        long startTime = System.currentTimeMillis();
        log.info("BusinessLogic2 실행");

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;

        log.info("result Time = {}", resultTime);
    }
}
