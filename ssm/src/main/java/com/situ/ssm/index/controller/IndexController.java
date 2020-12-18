/**
 * @Company:度半 
 * @Title:IndexController.java 
 * @Author:Sure-Li  
 * @Date:2020-12-17 11:38:09     
 */
package com.situ.ssm.index.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.situ.ssm.index.service.IndexService;
import com.situ.ssm.util.ConfigUtil;

/**
 * @ClassName:IndexController
 * @Description:(进系统首页)
 */
@Controller("indexController")
public class IndexController {
	@Autowired
	private IndexService indexService;

	/**
	 * 
	 * @Title: goindex
	 * @Description:(进首页)
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping({ "/", "/index" })
	public ModelAndView goindex(ModelAndView modelAndView, HttpSession session) {
		// WEB-INF/jsp/index.jsp
		if (session.getAttribute(ConfigUtil.SESSION_LOGIN_USER_NAME) == null) {
			modelAndView.setViewName("login");// 处于非登陆状态
		} else {
			modelAndView.setViewName("index");// 登录状态页面
		}
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

	@ResponseBody
	@RequestMapping("/dologin")
	public Integer doLogin(String userCode, String userPassword, HttpServletRequest request,
			HttpServletResponse response) {
		return indexService.doLogin(userCode, userPassword, request, response);
	}

	@ResponseBody
	@RequestMapping("/dologinout")
	public Integer doLoginOut(HttpSession session) {
		session.removeAttribute(ConfigUtil.SESSION_LOGIN_USER_NAME);
		return 1;

	}
}
