package com.ceac.easystudy.hystrix;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.ceac.easystudy.feign.KnowledgeFeign;
import com.ceac.easystudy.po.ResultMsg;

@Component
public class KnowledgeHystrix implements KnowledgeFeign {

	@Override
	public ResultMsg find(@RequestParam("subjectId") String sid) {
		return new ResultMsg(201, "微服务暂时不可用", sid);
	}

	@Override
	public ResultMsg remove(@RequestParam("subjectId") String sid) {
		return new ResultMsg(201, "微服务暂时不可用", sid);
	}
}
