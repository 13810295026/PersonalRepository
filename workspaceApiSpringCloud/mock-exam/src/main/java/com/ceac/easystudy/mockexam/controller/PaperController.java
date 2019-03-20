package com.ceac.easystudy.mockexam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceac.easystudy.mockexam.service.MockExamService;
import com.ceac.easystudy.po.ResultMsg;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@Api(tags = "模考试卷接口")
@RestController
@RequestMapping("/paper/")
public class PaperController {

	@Autowired
	MockExamService mockExamService;

	@ApiOperation(value = "取得试卷列表", httpMethod = "GET", notes = "根据科目id,取得模拟考试试卷列表")
	@ApiImplicitParam(name = "sid", value = "科目id", dataType = "String", paramType = "query")
	@ApiResponse(code = 200, message = "请求或处理成功")
	@GetMapping("find/{sid}")
	public ResultMsg find(@PathVariable String sid) {
		ResultMsg rm = new ResultMsg();
		rm.setStatusCode(200);
		rm.setInfo("请求或处理成功");
		rm.setData(mockExamService.findMockPapers(sid));

		return rm;
	}

	@ApiOperation(value = "取得试卷试题", httpMethod = "GET", notes = "根据试卷id,取得模拟考试试题json")
	@ApiImplicitParam(name = "pid", value = "试卷id", dataType = "String", paramType = "query")
	@ApiResponse(code = 200, message = "请求或处理成功")
	@GetMapping("questions/{pid}")
	public ResultMsg questions(@PathVariable String pid) {
		ResultMsg rm = new ResultMsg();
		rm.setStatusCode(200);
		rm.setInfo("请求或处理成功");
		rm.setData(mockExamService.findQuestions(pid));

		return rm;
	}
	
	@ApiOperation(value = "移除试卷列表", httpMethod = "GET", notes = "根据科目id,移除缓存中的试卷列表,不会删除数据库数据")
	@ApiImplicitParam(name = "sid", value = "科目id", dataType = "String", paramType = "query")
	@ApiResponse(code = 200, message = "请求或处理成功")
	@GetMapping("remove/{sid}")
	public ResultMsg removeCachePaper(@PathVariable String sid) {
		ResultMsg rm = new ResultMsg();
		rm.setStatusCode(200);
		rm.setInfo("请求或处理成功");
		mockExamService.removeCacheMockPapers(sid);

		return rm;
	}
	
	@ApiOperation(value = "移除试卷试题", httpMethod = "GET", notes = "根据试卷id,移除缓存中的试卷列表,不会删除数据库数据")
	@ApiImplicitParam(name = "pid", value = "试卷id", dataType = "String", paramType = "query")
	@ApiResponse(code = 200, message = "请求或处理成功")
	@GetMapping("questions/remove/{pid}")
	public ResultMsg removeCacheQuestion(@PathVariable String pid) {
		ResultMsg rm = new ResultMsg();
		rm.setStatusCode(200);
		rm.setInfo("请求或处理成功");
		mockExamService.removeCacheQuestions(pid);

		return rm;
	}
}