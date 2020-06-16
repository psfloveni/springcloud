package com.psf.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName： GatewayConfig
 * @Auther: Administrator
 * @Date: 2020/6/8 14:29
 * @return version 1.0
 */

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route",r -> r.path("/baidu").uri("https://www.baidu.com")).build();

        return routes.build();
    }
}
