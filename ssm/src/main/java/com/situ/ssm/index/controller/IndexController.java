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
	/**
	 * 
	 * @Title: goindex 
	 * @Description:(进首页)
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping({ "/", "/index" })
	public ModelAndView goindex(ModelAndView modelAndView) {
		// WEB-INF/jsp/index.jsp
		modelAndView.setViewName("index");
		return modelAndView;
	}
	/**
	 * 
	 * @Title: goLogin 
	 * @Description:(进登录页面)
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView goLogin(ModelAndView modelAndView) {
		// WEB-INF/jsp/login.jsp
		modelAndView.setViewName("login");
		return modelAndView;
	}
}
