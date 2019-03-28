package com.ceac.easystudy.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ceac.easystudy.hystrix.SubjectHystrix;
import com.ceac.easystudy.po.ResultMsg;

@FeignClient(name = "provider-mockexam", fallback = SubjectHystrix.class)
public interface SubjectFeign {

	@RequestMapping("/subject/find")
	public ResultMsg find();

	@RequestMapping("/subject/remove")
	public ResultMsg remove();
}
