package com.ceac.easystudy.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ceac.easystudy.po.ResultMsg;

@FeignClient("provider-mockexam")
public interface PaperFeign {

	@RequestMapping("/paper/find/{sid}")
	public ResultMsg find(@PathVariable("sid") String sid);

	@RequestMapping("/paper/questions/{pid}")
	public ResultMsg questions(@PathVariable("pid") String pid);
	
	@RequestMapping("/paper/remove/{sid}")
	public ResultMsg remove(@PathVariable("sid") String sid);

	@RequestMapping("/paper/questions/remove/{pid}")
	public ResultMsg removeCache(@PathVariable("pid") String pid);

}
