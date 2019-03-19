package com.ceac.easystudy.mockexercises.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceac.easystudy.mockexercises.service.ExercisesService;
import com.ceac.easystudy.po.ResultMsg;

@RestController
@RequestMapping("/exercises/")
public class ExercisesController {

	@Autowired
	ExercisesService exercisesService;
	
	@GetMapping("extract/{kid}")
	public ResultMsg extract(@PathVariable String kid) {
		ResultMsg rm = new ResultMsg();
		rm.setStatusCode(200);
		rm.setInfo("请求或处理成功");
		rm.setData(exercisesService.extract(kid));

		return rm;
	}
}
