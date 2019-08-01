package com.ccut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @ClassName: GatewayApplication
 * @Description: TODO   网关启动类
 * @Author: Mark
 * @Date: 2019/7/29 18:10
 * @version: V1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class);
    }
}
