/**
 * @Company:度半 
 * @Title:IndexController.java 
 * @Author:Sure-Li  
 * @Date:2020-12-17 11:38:09     
 */
package com.situ.ssm.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName:IndexController
 * @Description:(进系统首页)
 */
@Controller
public class IndexController {
	@RequestMapping({ "/", "/index" })
	public ModelAndView goindex(ModelAndView modelAndView) {
		// WEB-INF/jsp/index.jsp
		modelAndView.setViewName("index");
		return modelAndView;
	}
}
