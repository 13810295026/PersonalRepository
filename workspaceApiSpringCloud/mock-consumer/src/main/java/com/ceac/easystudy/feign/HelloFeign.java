package com.ceac.easystudy.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "provider-mockexam")
public interface HelloFeign {

	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable("name") String name);
}
