package com.webflux;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;

/**
 * @Desc: 测试用例
 * @Author: chenbo
 * @Date: 2019/8/23 10:40
 **/
public class FluxTest {

    @Test
    public void testBase() throws Exception {
        Flux.just("hello", "world").subscribe(System.out::println);
        Flux.fromArray(new Integer[]{1,20,33}).subscribe(System.out::println);

        Flux.empty().subscribe(System.out::println);
        Flux.range(1,10).subscribe(System.out::println);

        Flux.interval(Duration.of(1, ChronoUnit.SECONDS)).subscribe(System.out::println);
        //防止程序过早退出，放一个CountDownLatch拦住
        CountDownLatch latch = new CountDownLatch(1);
        latch.await();
    }

    @Test
    public void testCreate() {
        Flux.create((t) -> {
            t.next("cr");
            t.next("cr2");
            t.complete();
        }).subscribe(System.out::println);
    }

    @Test
    public void testMono() {
        Mono.fromSupplier(() -> "Hello").subscribe(System.out::println);
        Mono.justOrEmpty(Optional.of("Hello===")).subscribe(System.out::println);
        Mono.create(sink -> sink.success("Hello+++")).subscribe(System.out::println);
    }

}
