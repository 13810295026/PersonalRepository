package com.ceac.easystudy.mockexercises.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceac.easystudy.mockexercises.service.ExercisesService;
import com.ceac.easystudy.po.ResultMsg;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@Api(tags = "练习题接口")
@RestController
@RequestMapping("/exercises/")
public class ExercisesController {

	@Autowired
	ExercisesService exercisesService;

	@ApiOperation(value = "随机抽题", httpMethod = "GET", notes = "根据知识点的id随机抽取5道练习题")
	@ApiImplicitParam(name = "kid", value = "知识点id", dataType = "String", paramType = "query")
	@ApiResponse(code = 200, message = "请求或处理成功")
	@GetMapping("extract/{kid}")
	public ResultMsg extract(@PathVariable String kid) {
		ResultMsg rm = new ResultMsg();
		rm.setStatusCode(200);
		rm.setInfo("请求或处理成功");
		rm.setData(exercisesService.extract(kid));

		return rm;
	}
}
