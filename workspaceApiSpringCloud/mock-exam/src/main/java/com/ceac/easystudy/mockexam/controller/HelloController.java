package com.ceac.easystudy.mockexam.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class HelloController {

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Resource(name = "stringRedisTemplate")
	ValueOperations<String, String> valOps;

	@Value("${esver}")
	String esver;

	@GetMapping("/hello/{version:.+}")
	public String hello(@PathVariable String version) {
		valOps.increment("mock-client-" + version, 1);//val加1操作
		return "1:" + esver + "|" + version;
	}
}
