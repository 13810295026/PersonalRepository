package com.ceac.easystudy.mockexercises.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceac.easystudy.mockexercises.service.KnowledgeService;
import com.ceac.easystudy.po.ResultMsg;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@Api(tags = "知识点接口")
@RestController
@RequestMapping("/knowledge/")
public class KnowledgeController {

	@Autowired
	KnowledgeService knowledgeService;

	@ApiOperation(value = "取得知识点树", httpMethod = "GET", notes = "根据科目id,取得知识点树(2级树结构)")
	@ApiImplicitParam(name = "sid", value = "科目id", dataType = "String", paramType = "query")
	@ApiResponse(code = 200, message = "请求或处理成功")
	@GetMapping("find/{sid}")
	public ResultMsg find(@PathVariable String sid) {
		ResultMsg rm = new ResultMsg();
		rm.setStatusCode(200);
		rm.setInfo("请求或处理成功");
		rm.setData(knowledgeService.findKnowledges(sid));

		return rm;
	}

	@ApiOperation(value = "移除知识点树", httpMethod = "GET", notes = "根据科目id,移除缓存中的知识点树,不会删除数据库数据)")
	@ApiImplicitParam(name = "sid", value = "科目id", dataType = "String", paramType = "query")
	@ApiResponse(code = 200, message = "请求或处理成功")
	@GetMapping("remove/{sid}")
	public ResultMsg remove(@PathVariable String sid) {
		ResultMsg rm = new ResultMsg();
		rm.setStatusCode(200);
		rm.setInfo("请求或处理成功");
		knowledgeService.removeCache(sid);

		return rm;
	}
}
