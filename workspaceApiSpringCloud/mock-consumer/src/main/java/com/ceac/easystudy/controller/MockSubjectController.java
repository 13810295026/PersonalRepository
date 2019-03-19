package com.ceac.easystudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceac.easystudy.feign.SubjectFeign;
import com.ceac.easystudy.po.ResultMsg;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/MockExamSubject/")
public class MockSubjectController {

	@Autowired
	private SubjectFeign subjectFeign;

	@RequestMapping(value = "GetSubjectInfos", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "subjectFallback")
	public ResultMsg subjects() {
		return subjectFeign.subjects();
	}

	@RequestMapping("RemoveSubjects")
	public ResultMsg remove() {
		return subjectFeign.remove();
	}

	public ResultMsg subjectFallback() {
		return new ResultMsg(201, "微服务暂时不可用");
	}
}
