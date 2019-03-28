package com.ceac.easystudy.mockexam.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ceac.easystudy.mockexam.interceptor.HelloInterceptor;

//@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new HelloInterceptor()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}
}
