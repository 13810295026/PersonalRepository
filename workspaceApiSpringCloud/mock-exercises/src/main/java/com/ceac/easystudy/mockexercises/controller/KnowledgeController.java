package com.ceac.easystudy.mockexercises.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceac.easystudy.mockexercises.service.KnowledgeService;
import com.ceac.easystudy.po.ResultMsg;

@RestController
@RequestMapping("/knowledge/")
public class KnowledgeController {

	@Autowired
	KnowledgeService knowledgeService;

	@GetMapping("find/{sid}")
	public ResultMsg find(@PathVariable String sid) {
		ResultMsg rm = new ResultMsg();
		rm.setStatusCode(200);
		rm.setInfo("请求或处理成功");
		rm.setData(knowledgeService.findKnowledges(sid));

		return rm;
	}

	@GetMapping("remove/{sid}")
	public ResultMsg remove(@PathVariable String sid) {
		ResultMsg rm = new ResultMsg();
		rm.setStatusCode(200);
		rm.setInfo("请求或处理成功");
		knowledgeService.removeCache(sid);

		return rm;
	}
}
