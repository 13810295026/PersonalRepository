package com.ceac.easystudy.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ceac.easystudy.po.ResultMsg;

@FeignClient("provider-mockexercises")
public interface KnowledgeFeign {
	
	@RequestMapping("/knowledge/find/{sid}")
	public ResultMsg find(@PathVariable("sid") String sid);
	
	@RequestMapping("/knowledge/remove/{sid}")
	public ResultMsg remove(@PathVariable("sid") String sid);
}
