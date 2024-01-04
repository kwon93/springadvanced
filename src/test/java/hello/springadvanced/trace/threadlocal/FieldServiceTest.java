package hello.springadvanced.trace.threadlocal;

import hello.springadvanced.trace.threadlocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldServiceTest {

    private final FieldService fieldService = new FieldService();
    @Test
    @DisplayName("동시성 문제 발생 전 정상 수행")
    void field(){
        log.info("main start");
        Runnable userA = () -> {
            fieldService.logic("userA");
        };

        Runnable userB = () -> {
            fieldService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("tread-a");
        Thread threadB = new Thread(userB);
        threadB.setName("tread-b");

        threadA.start();
        sleep(2000);
        threadB.start();
        sleep(2500);
    }
    @Test
    @DisplayName("동시성 문제 발생")
    void field2(){
        log.info("main start");
        Runnable userA = () -> {
            fieldService.logic("userA");
        };

        Runnable userB = () -> {
            fieldService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("tread-a");
        Thread threadB = new Thread(userB);
        threadB.setName("tread-b");

        threadA.start();
        sleep(100);
        threadB.start();
        sleep(2500);
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }
    }

}
