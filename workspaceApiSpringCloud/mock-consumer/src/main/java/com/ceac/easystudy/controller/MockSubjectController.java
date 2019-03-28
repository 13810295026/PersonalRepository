package com.ceac.easystudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceac.easystudy.feign.SubjectFeign;
import com.ceac.easystudy.po.ResultMsg;

@RestController
@RequestMapping("/MockExamSubject/")
public class MockSubjectController {

	@Autowired
	private SubjectFeign subjectFeign;

	@RequestMapping(value = "GetSubjectInfos", method = RequestMethod.GET)
	public ResultMsg subjects() {
		return subjectFeign.find();
	}

	@RequestMapping("RemoveSubjects")
	public ResultMsg remove() {
		return subjectFeign.remove();
	}
}
