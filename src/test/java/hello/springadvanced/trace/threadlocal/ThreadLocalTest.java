package hello.springadvanced.trace.threadlocal;

import hello.springadvanced.trace.threadlocal.code.FieldService;
import hello.springadvanced.trace.threadlocal.code.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class ThreadLocalTest {
    private final ThreadLocalService service = new ThreadLocalService();
    @Test
    @DisplayName("동시성 문제 발생 전 정상 수행")
    void field(){
        log.info("main start");
        Runnable userA = () -> {
            service.logic("userA");
        };

        Runnable userB = () -> {
            service.logic("userB");
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
    @DisplayName("동시성 문제 발생 상황 ThreadLocal 동작")
    void field2(){
        log.info("main start");
        Runnable userA = () -> {
            service.logic("userA");
        };

        Runnable userB = () -> {
            service.logic("userB");
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
