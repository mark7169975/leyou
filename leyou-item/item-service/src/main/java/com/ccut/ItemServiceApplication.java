package com.ccut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ClassName: ItemServiceApplication
 * @Description: TODO   商品启动类
 * @Author: Mark
 * @Date: 2019/7/30 8:52
 * @version: V1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.ccut.item.mapper")
public class ItemServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ItemServiceApplication.class);
    }
}
