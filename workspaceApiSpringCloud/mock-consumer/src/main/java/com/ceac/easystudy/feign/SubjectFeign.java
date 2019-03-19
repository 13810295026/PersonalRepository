package com.ceac.easystudy.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ceac.easystudy.po.ResultMsg;

@FeignClient("provider-mockexam")
public interface SubjectFeign {

	@RequestMapping("/subject/find")
	public ResultMsg subjects();
	
	@RequestMapping("/subject/remove")
	public ResultMsg remove();
}
