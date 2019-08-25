package com.chenpeini.webflux.route;

import com.chenpeini.webflux.handler.DemoHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @Desc:
 * @Author: chenbo
 * @Date: 2019/8/23 11:15
 **/
@Configuration
public class DemoRouter {

    @Bean
    public RouterFunction<ServerResponse> route(DemoHandler demoHandler) {
        return  RouterFunctions.route(RequestPredicates.GET("/demo/get"), demoHandler::get);
    }

}
