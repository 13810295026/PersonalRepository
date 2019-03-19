package com.ceac.easystudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceac.easystudy.feign.KnowledgeFeign;
import com.ceac.easystudy.po.ResultMsg;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/ExercisesKnowledgee/")
public class KnowledgeController {

	@Autowired
	private KnowledgeFeign knowledgeFeign;

	@RequestMapping(value = "GetKnowledgeInfo", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "knowledgesFallback")
	public ResultMsg knowledges(@RequestParam("subjectId") String sid) {
		return knowledgeFeign.find(sid);
	}

	@RequestMapping("RemoveKnowledges")
	public ResultMsg remove(@RequestParam("subjectId") String sid) {
		return knowledgeFeign.remove(sid);
	}

	public ResultMsg knowledgesFallback(@RequestParam("subjectId") String sid) {
		return new ResultMsg(201, "微服务暂时不可用", sid);
	}
}
