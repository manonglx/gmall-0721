package com.atguigu.gmall.psm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.atguigu.gmall.psm.dao")
@EnableSwagger2
@RefreshScope
public class GmallPsmApplication {

	public static void main(String[] args) {
		SpringApplication.run(GmallPsmApplication.class, args);
	}

}
