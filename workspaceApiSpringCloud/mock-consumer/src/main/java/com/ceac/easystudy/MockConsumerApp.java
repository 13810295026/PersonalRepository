package com.ceac.easystudy;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringCloudApplication
@EnableFeignClients //开启feign
@EnableHystrixDashboard
//@EnableCircuitBreaker //开启hystrix（已包含）
public class MockConsumerApp {
	public static void main(String[] args) {
		SpringApplication.run(MockConsumerApp.class, args);
	}
}
