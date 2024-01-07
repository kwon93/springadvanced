package hello.springadvanced.trace.strategy.code.template;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeLogTemplate {

    public void execute(Callback callback){
        long startTime = System.currentTimeMillis();

        callback.call(); // 비지니스로직 실행

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("result Time = {}", resultTime);
    }
}
