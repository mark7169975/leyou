package com.ccut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName: RegistryApplication
 * @Description: TODO   注册中心启动类
 * @Author: Mark
 * @Date: 2019/7/29 17:36
 * @version: V1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class RegistryApplication {
    public static void main(String[] args) {
        SpringApplication.run(RegistryApplication.class);
    }
}
