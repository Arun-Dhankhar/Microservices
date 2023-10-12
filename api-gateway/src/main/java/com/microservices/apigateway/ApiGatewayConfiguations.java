package com.microservices.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguations {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
        		.route(r->r.path("/get").uri("http://httpbin.org:80"))
        		.route(r->r.path("/currency-exchange/**").uri("lb://currency-exchange-service"))
        		.route(r->r.path("/currency-conversion/**").uri("lb://currency-conversion"))
        		.route(r->r.path("/currency-conversion-feign/**").uri("lb://currency-conversion"))

        		.build();
    }
}
