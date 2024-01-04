package hello.springadvanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FieldService {

    //각 쓰레드들이 동시적으로 저장하려하는 필드, 동시성문제 발생.
    private String nameStore;

    public String logic(String name) {
        log.info("저장 name = {} -> nameStore = {}",name, nameStore);
        nameStore = name;
        sleep(1000);
        log.info("조회 nameStore = {}", nameStore);
        return nameStore;
    }

    public void sleep(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
