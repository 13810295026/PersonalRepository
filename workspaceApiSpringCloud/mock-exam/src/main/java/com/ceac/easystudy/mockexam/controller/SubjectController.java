package com.ceac.easystudy.mockexam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceac.easystudy.mockexam.service.SubjectService;
import com.ceac.easystudy.po.ResultMsg;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@Api(tags = "模考科目接口")
@RestController
@RequestMapping("/subject/")
public class SubjectController {
	
	@Autowired
	SubjectService subjectService;
	
	@ApiOperation(value = "取得科目列表", httpMethod = "GET", notes = "取得模拟考试科目列表")
	@ApiResponse(code = 200, message = "请求或处理成功")
	@GetMapping("find")
	public ResultMsg find(){
		ResultMsg rm = new ResultMsg();
		rm.setStatusCode(200);
		rm.setInfo("请求或处理成功");
		rm.setData(subjectService.findSubjects());

		return rm;
	}
	
	@ApiOperation(value = "移除科目列表", httpMethod = "GET", notes = "移除缓存中的科目列表,不会删除数据库数据")
	@ApiResponse(code = 200, message = "请求或处理成功")
	@GetMapping("remove")
	public ResultMsg remove(){
		ResultMsg rm = new ResultMsg();
		rm.setStatusCode(200);
		rm.setInfo("请求或处理成功");
		subjectService.removeCache();

		return rm;
	}
}
