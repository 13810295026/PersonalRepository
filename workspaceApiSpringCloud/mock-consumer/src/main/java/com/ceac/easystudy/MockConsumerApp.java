package com.ceac.easystudy;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringCloudApplication
@EnableFeignClients //开启feign
@EnableHystrixDashboard
@EnableTurbine
//@EnableCircuitBreaker //开启hystrix（@SpringCloudApplication已包含）
public class MockConsumerApp {
	public static void main(String[] args) {
		SpringApplication.run(MockConsumerApp.class, args);
	}
}
