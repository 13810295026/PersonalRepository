package com.ceac.easystudy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceac.easystudy.po.ResultMsg;

@RestController
public class ErrorController {

	@RequestMapping("/404.do")
	public ResultMsg error() {
		return new ResultMsg(404, "接口异常", "你调用的接口不见了");
	}

}
