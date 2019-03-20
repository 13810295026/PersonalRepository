package com.ceac.easystudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceac.easystudy.feign.ExercisesFeign;
import com.ceac.easystudy.po.ResultMsg;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/ExercisesQuestion/")
public class ExercisesController {

	@Autowired
	private ExercisesFeign exercisesFeign;

	@RequestMapping(value = "GetPaperQuestionInfo", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "exercisesFallback")
	public ResultMsg extract(@RequestParam("knowledgeId") String kid) {
		return exercisesFeign.extract(kid);
	}
	
	public ResultMsg exercisesFallback(@RequestParam("knowledgeId") String kid) {
		return new ResultMsg(201, "微服务暂时不可用", kid);
	}
}
