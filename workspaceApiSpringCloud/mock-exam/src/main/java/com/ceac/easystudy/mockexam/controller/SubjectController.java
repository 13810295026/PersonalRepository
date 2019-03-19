package com.ceac.easystudy.mockexam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceac.easystudy.mockexam.service.SubjectService;
import com.ceac.easystudy.po.ResultMsg;

@RestController
@RequestMapping("/subject/")
public class SubjectController {
	
	@Autowired
	SubjectService subjectService;
	
	@GetMapping("find")
	public ResultMsg find(){
		ResultMsg rm = new ResultMsg();
		rm.setStatusCode(200);
		rm.setInfo("请求或处理成功");
		rm.setData(subjectService.findSubjects());

		return rm;
	}
	
	@GetMapping("remove")
	public ResultMsg remove(){
		ResultMsg rm = new ResultMsg();
		rm.setStatusCode(200);
		rm.setInfo("请求或处理成功");
		subjectService.removeCache();

		return rm;
	}
}
