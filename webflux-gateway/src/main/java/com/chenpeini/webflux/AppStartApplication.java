package com.chenpeini.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * @Desc:
 * @Author: chenbo
 * @Date: 2019/8/22 10:40
 **/
@SpringBootApplication
public class AppStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppStartApplication.class, args);
    }

    @Bean
    public TestHandler testHandler() {
        return new TestHandler();
    }

    @Bean
    public RouterFunction<ServerResponse> routes() {
        return RouterFunctions.route(RequestPredicates.GET("/route"), testHandler()::echoName);
    }

    class TestHandler {

        public Mono<ServerResponse> echoName(ServerRequest request) {
            Optional<String> param = request.queryParam("name");
            //String s = request.bodyToMono(String.class).subscribe(st -> return"Hello world" + st);
            return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(BodyInserters.fromObject("hello word===" + param.get()));
        }

    }

}
