package com.ceac.easystudy.mockexam.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class HelloController {

	@Value("${esver}")
	String esver;

	@GetMapping("/hello/{name}")
	public String hello(@PathVariable String name) {
		return "1:" + esver + "|" + name;
	}
}
