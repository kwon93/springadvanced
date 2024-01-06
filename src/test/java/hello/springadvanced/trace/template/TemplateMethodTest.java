package hello.springadvanced.trace.template;

import hello.springadvanced.trace.template.code.AbstractTemplate;
import hello.springadvanced.trace.template.code.SubClassLogic1;
import hello.springadvanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    /**
     * templateMethodPattern 적용 X
     */
    @Test
    void templateMethodV0() {
        logic1();
        logic2();

    }

    /**
     * templateMethodPattern 적용 O
     */
    @Test
    void tempalteMethodV1() {
        AbstractTemplate template1 = new SubClassLogic1();
        template1.execute();

        AbstractTemplate template2 = new SubClassLogic2();
        template2.execute();

    }

    /**
     * templateMethodPattern 적용 O
     */
    @Test
    void templateMethodV2() {
        AbstractTemplate template1 = new AbstractTemplate(){
            @Override
            protected void call(){
                log.info("BusinessLogic1 실행.");
            }
        };
        template1.execute();

        AbstractTemplate template2 = new AbstractTemplate(){
            @Override
            protected void call(){
                log.info("BusinessLogic2 실행.");
            }
        };
        template2.execute();
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
