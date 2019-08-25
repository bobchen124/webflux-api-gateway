package com.chenpeini.webflux.handler;

import com.chenpeini.webflux.params.DemoParam;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


/**
 * @Desc:
 * @Author: chenbo
 * @Date: 2019/8/23 09:41
 **/
@Component
public class DemoHandler {

    public Mono<ServerResponse> get(ServerRequest request) {
        MultiValueMap<String, String> multiValueMap = request.queryParams();
        final Mono<DemoParam> paramMono = request.bodyToMono(DemoParam.class);
        System.out.println("====" + paramMono.toString());
        Integer age = paramMono.map(p -> p.getAge()).block();

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromObject(multiValueMap.get("name").get(0) + "--" + multiValueMap.get("age").get(0)));
    }

}