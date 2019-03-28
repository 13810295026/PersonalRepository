package com.ceac.easystudy.hystrix;

import org.springframework.stereotype.Component;

import com.ceac.easystudy.feign.SubjectFeign;
import com.ceac.easystudy.po.ResultMsg;

@Component
public class SubjectHystrix implements SubjectFeign {

	@Override
	public ResultMsg find() {
		return new ResultMsg(201, "微服务暂时不可用", "科目");
	}

	@Override
	public ResultMsg remove() {
		return new ResultMsg(201, "微服务暂时不可用", "科目");
	}
}
