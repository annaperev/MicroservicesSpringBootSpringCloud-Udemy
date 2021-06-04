package com.in28minutes.microservices.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
        return builder.routes()
                   .route(p -> p.path("/get") //if request comes to /get
                           .filters(f -> f
                           .addRequestHeader("MyHeader", "MyURI")
                           .addRequestParameter("Param","MyParam"))
                           .uri("http://httpbin.org:80"))//then we redirect to specific uri
                   .route(p -> p.path("/currency-exchange/**") //if request starts with  /currency-exchange/
                           // then eureka will find the location of service "currency-exchange"
                            .uri("lb://currency-exchange")) // "lb:  - this turn on load balance between instances of the services
                   .route(p -> p.path("/currency-conversion/**")
                           .uri("lb://currency-conversion"))
                   .route(p -> p.path("/currency-conversion-feign/**")
                        .uri("lb://currency-conversion"))
                   .route(p -> p.path("/currency-conversion-new/**")
                        .filters(f -> f.rewritePath( //explained in 152 lecture https://www.udemy.com/course/microservices-with-spring-boot-and-spring-cloud/learn/lecture/24346944#overview
                                "currency-conversion-new/(?<segment>.*)"
                                ,"currency-conversion-feign/${segment}"))
                        .uri("lb://currency-conversion"))
                   .build();
    }


}
