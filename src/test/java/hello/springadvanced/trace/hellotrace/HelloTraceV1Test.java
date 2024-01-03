package hello.springadvanced.trace.hellotrace;

import hello.springadvanced.trace.TraceStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloTraceV1Test {


    @Test
    @DisplayName("log Trace 정상 동작 확인")
    void test1() {
        //given
        HelloTraceV1 trace = new HelloTraceV1();

        // when
        TraceStatus status = trace.begin("hello");

        //then
        trace.end(status);
    }


    @Test
    @DisplayName("log Trace exception 정상 동작 확인")
    void test() {
        //given
        HelloTraceV1 trace = new HelloTraceV1();

        // when
        TraceStatus status = trace.begin("ex");
        IllegalStateException e = new IllegalStateException();

        //then
        trace.exception(status,e);

    }
}