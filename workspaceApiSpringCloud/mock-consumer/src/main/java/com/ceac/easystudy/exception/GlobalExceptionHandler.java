package com.ceac.easystudy.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ceac.easystudy.po.ResultMsg;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResultMsg defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		return new ResultMsg(500, "系统异常", e.getMessage());
	}

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return (container -> {
			ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.do");
			container.addErrorPages(error404Page);
		});
	}
}
