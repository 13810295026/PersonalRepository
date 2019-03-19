package com.ceac.easystudy.mockexam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceac.easystudy.mockexam.service.MockExamService;
import com.ceac.easystudy.po.ResultMsg;

@RestController
@RequestMapping("/paper/")
public class PaperController {

	@Autowired
	MockExamService mockExamService;

	@GetMapping("find/{sid}")
	public ResultMsg find(@PathVariable String sid) {
		ResultMsg rm = new ResultMsg();
		rm.setStatusCode(200);
		rm.setInfo("请求或处理成功");
		rm.setData(mockExamService.findMockPapers(sid));

		return rm;
	}

	@GetMapping("questions/{pid}")
	public ResultMsg questions(@PathVariable String pid) {
		ResultMsg rm = new ResultMsg();
		rm.setStatusCode(200);
		rm.setInfo("请求或处理成功");
		rm.setData(mockExamService.findQuestions(pid));

		return rm;
	}
	
	@GetMapping("remove/{sid}")
	public ResultMsg removeCachePaper(@PathVariable String sid) {
		ResultMsg rm = new ResultMsg();
		rm.setStatusCode(200);
		rm.setInfo("请求或处理成功");
		mockExamService.removeCacheMockPapers(sid);

		return rm;
	}
	
	@GetMapping("questions/remove/{pid}")
	public ResultMsg removeCacheQuestion(@PathVariable String pid) {
		ResultMsg rm = new ResultMsg();
		rm.setStatusCode(200);
		rm.setInfo("请求或处理成功");
		mockExamService.removeCacheQuestions(pid);

		return rm;
	}
}