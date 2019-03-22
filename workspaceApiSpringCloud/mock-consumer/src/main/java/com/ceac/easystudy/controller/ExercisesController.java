package com.ceac.easystudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceac.easystudy.feign.ExercisesFeign;
import com.ceac.easystudy.po.ResultMsg;

@RestController
@RequestMapping("/ExercisesQuestion/")
public class ExercisesController {

	@Autowired
	private ExercisesFeign exercisesFeign;

	@RequestMapping(value = "GetPaperQuestionInfo", method = RequestMethod.GET)
	public ResultMsg extract(@RequestParam("knowledgeId") String kid) {
		return exercisesFeign.extract(kid);
	}
}
