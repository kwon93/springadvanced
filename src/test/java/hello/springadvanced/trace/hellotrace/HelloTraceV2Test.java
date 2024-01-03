package hello.springadvanced.trace.hellotrace;

import hello.springadvanced.trace.TraceStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloTraceV2Test {


    @Test
    @DisplayName("log Trace 정상 동작 확인")
    void test1() {
        //given
        HelloTraceV2 trace = new HelloTraceV2();

        // when
        TraceStatus status = trace.begin("hello");
        TraceStatus status2 = trace.beginSync(status.getTraceId(), "hello 2");

        //then
        trace.end(status2);
        trace.end(status);
    }


    @Test
    @DisplayName("log Trace exception 정상 동작 확인")
    void test() {
        //given
        HelloTraceV2 trace = new HelloTraceV2();

        // when
        TraceStatus status = trace.begin("ex");
        TraceStatus status2 = trace.beginSync(status.getTraceId(), "ex2");
        IllegalStateException e = new IllegalStateException();

        //then
        trace.exception(status2,e);
        trace.exception(status,e);

    }
}