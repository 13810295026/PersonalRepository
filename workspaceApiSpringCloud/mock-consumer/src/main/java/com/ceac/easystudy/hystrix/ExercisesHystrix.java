package com.ceac.easystudy.hystrix;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.ceac.easystudy.feign.ExercisesFeign;
import com.ceac.easystudy.po.ResultMsg;

@Component
public class ExercisesHystrix implements ExercisesFeign {

	@Override
	public ResultMsg extract(@RequestParam("knowledgeId") String kid) {
		return new ResultMsg(201, "微服务暂时不可用", kid);
	}
}
