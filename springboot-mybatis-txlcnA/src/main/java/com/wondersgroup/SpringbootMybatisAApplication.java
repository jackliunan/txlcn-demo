package com.wondersgroup;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableDistributedTransaction
@EnableFeignClients
@MapperScan("com.wondersgroup.mapper")
public class SpringbootMybatisAApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisAApplication.class, args);
    }

}
