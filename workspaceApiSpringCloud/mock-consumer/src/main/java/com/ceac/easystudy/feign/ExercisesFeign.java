package com.ceac.easystudy.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ceac.easystudy.po.ResultMsg;

@FeignClient("provider-mockexercises")
public interface ExercisesFeign {

	@RequestMapping("/exercises/extract/{kid}")
	public ResultMsg extract(@PathVariable("kid") String kid);
}
