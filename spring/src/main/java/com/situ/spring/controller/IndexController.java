package com.situ.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class IndexController {
	@RequestMapping("/hello1")
//	@ResponseBody
	public String doHello() {
		System.out.println("接受到了前台页面的请求");
		/* return "hello.jsp"; */
		return "hello";
	}
}
