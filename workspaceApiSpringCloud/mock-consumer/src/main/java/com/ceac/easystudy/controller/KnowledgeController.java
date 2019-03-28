package com.ceac.easystudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceac.easystudy.feign.KnowledgeFeign;
import com.ceac.easystudy.po.ResultMsg;

@RestController
@RequestMapping("/ExercisesKnowledgee/")
public class KnowledgeController {

	@Autowired
	private KnowledgeFeign knowledgeFeign;

	@RequestMapping(value = "GetKnowledgeInfo", method = RequestMethod.GET)
	public ResultMsg knowledges(@RequestParam("subjectId") String sid) {
		return knowledgeFeign.find(sid);
	}

	@RequestMapping("RemoveKnowledges")
	public ResultMsg remove(@RequestParam("subjectId") String sid) {
		return knowledgeFeign.remove(sid);
	}
}
