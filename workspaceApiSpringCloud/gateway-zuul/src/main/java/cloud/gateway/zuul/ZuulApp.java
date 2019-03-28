package cloud.gateway.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import cloud.gateway.zuul.filter.ApiSecurityFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient // zuul服务要注册到Eureka上
public class ZuulApp {
	public static void main(String[] args) {
		SpringApplication.run(ZuulApp.class, args);
	}
/*
	//启动zuul签名验证过滤器
	@Bean
	public ApiSecurityFilter apiSecurityilter() {
		return new ApiSecurityFilter();
	}*/
}
