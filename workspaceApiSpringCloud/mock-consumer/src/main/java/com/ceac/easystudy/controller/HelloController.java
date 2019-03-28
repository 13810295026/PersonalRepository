package com.ceac.easystudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ceac.easystudy.feign.HelloFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class HelloController {

	@Autowired
	private HelloFeign helloFeign;

	@GetMapping("/hello/{version:.+}")//防止@PathVariable丢失带“.”的数据
	@HystrixCommand(fallbackMethod = "helloFallback")
	public String hello(@PathVariable String version) {
		return helloFeign.hello(version);
	}

	public String helloFallback(String version) {
		return "Hystrix:" + version; // 失败调用时，返回默认值
	}
}
