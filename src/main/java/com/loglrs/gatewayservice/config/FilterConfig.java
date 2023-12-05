package com.loglrs.gatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FilterConfig {
//    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/member-service/**")
                            .filters(f -> f.addRequestHeader("member-request", "member-request-header")
                                            .addResponseHeader("member-response", "member-response-header"))
                            .uri("http://localhost:9001"))
                .route(r -> r.path("/property-service/**")
                        .filters(f -> f.addRequestHeader("property-request", "property-request-header")
                                .addResponseHeader("property-response", "property-response-header"))
                        .uri("http://localhost:9002"))
                .build();
    }
}
