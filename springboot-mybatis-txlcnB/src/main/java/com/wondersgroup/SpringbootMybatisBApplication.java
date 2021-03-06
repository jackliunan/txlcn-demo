package com.wondersgroup;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableDistributedTransaction
@MapperScan("com.wondersgroup.mapper")
public class SpringbootMybatisBApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisBApplication.class, args);
    }

}
