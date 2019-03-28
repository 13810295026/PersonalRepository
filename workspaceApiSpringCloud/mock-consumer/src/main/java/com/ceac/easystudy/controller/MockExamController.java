package com.ceac.easystudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceac.easystudy.feign.PaperFeign;
import com.ceac.easystudy.po.ResultMsg;

@RestController
@RequestMapping("/MockExamPaperQuestion/")
public class MockExamController {

	@Autowired
	private PaperFeign paperFeign;

	@RequestMapping(value = "GetPaperInfos", method = RequestMethod.GET)
	public ResultMsg paperInfos(String subId) {
		return paperFeign.find(subId);
	}

	@RequestMapping(value = "GetQuestInfos", method = RequestMethod.GET)
	public ResultMsg questions(@RequestParam("pId") String pid) {
		return paperFeign.questions(pid);
	}

	@RequestMapping("RemovePapers")
	public ResultMsg removePapers(String subId) {
		return paperFeign.remove(subId);
	}

	@RequestMapping("RemoveQuestions")
	public ResultMsg removeQuestions(@RequestParam("pId") String pid) {
		return paperFeign.removeCache(pid);
	}
}
