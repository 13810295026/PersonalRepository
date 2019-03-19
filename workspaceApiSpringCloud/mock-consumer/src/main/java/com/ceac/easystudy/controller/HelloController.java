package com.ceac.easystudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ceac.easystudy.feign.HelloFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class HelloController {

	// @Autowired
	// private RestTemplate restTemplate;
	
	@Autowired
	private HelloFeign helloFeign;
	
	@GetMapping("/hello/{name}")
	@HystrixCommand(fallbackMethod = "helloFallback")
	public String hello(@PathVariable String name) {

//		String url = "http://provider-mockexam/hello/" + name;
//		return this.restTemplate.getForObject(url, String.class);
		
		return helloFeign.hello(name);
	}

	public String helloFallback(String name) {
		return "Hystrix:" + name; // 失败调用时，返回默认值
	}
}
