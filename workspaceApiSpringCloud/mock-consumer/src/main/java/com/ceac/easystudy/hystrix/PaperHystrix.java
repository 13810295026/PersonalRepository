package com.ceac.easystudy.hystrix;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.ceac.easystudy.feign.PaperFeign;
import com.ceac.easystudy.po.ResultMsg;

@Component
public class PaperHystrix implements PaperFeign {

	@Override
	public ResultMsg find(String subId) {
		return new ResultMsg(201, "微服务暂时不可用", subId);
	}

	@Override
	public ResultMsg questions(@RequestParam("pId") String pid) {
		return new ResultMsg(201, "微服务暂时不可用", pid);
	}

	@Override
	public ResultMsg remove(String subId) {
		return new ResultMsg(201, "微服务暂时不可用", subId);
	}

	@Override
	public ResultMsg removeCache(@RequestParam("pId") String pid) {
		return new ResultMsg(201, "微服务暂时不可用", pid);
	}
}
