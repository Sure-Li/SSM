/**
 * @Company:度半 
 * @Title:IndexController.java 
 * @Author:Sure-Li  
 * @Date:2020-12-17 11:38:09     
 */
package com.situ.ssm.index.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.situ.ssm.index.service.IndexService;
import com.situ.ssm.interceptor.MyInterceptor;
import com.situ.ssm.user.service.UserService;
import com.situ.ssm.util.ConfigUtil;

/**
 * @ClassName:IndexController
 * @Description:(进系统首页)
 */
@Controller("indexController")
public class IndexController {
	private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);
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
	public ModelAndView goindex(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response,
			@CookieValue(name = ConfigUtil.COOKIE_NAME, required = false) String cookieValue) {
		LOG.debug("进入index页面");
		System.out.println("cookieValue" + cookieValue);
//		从浏览器得到cookie 数据 并处理
		if (cookieValue != null && !"".equals(cookieValue)) {
			System.out.println("自动登录");
			indexService.autoLogin(cookieValue, request);
		} else {
		}
		Cookie[] cookies =  request.getCookies();
		System.out.println("--------------------");
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName());
		}
		// 进行自动登录处理
		// WEB-INF/jsp/index.jsp
		if (request.getSession().getAttribute(ConfigUtil.SESSION_LOGIN_USER_NAME) == null) {
			modelAndView.setViewName("login");// 处于非登陆状态
		} else {
			modelAndView.setViewName("index");// 登录状态页面
			System.out.println("modelAndView.setViewName(\"index\");// 登录状态页面");
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
	public Integer doLogin(String userCode, String userPassword, String isRemenber, HttpServletRequest request,
			HttpServletResponse response) {
		return indexService.doLogin(userCode, userPassword, isRemenber, request, response);
	}

	@ResponseBody 
	@RequestMapping("/dologinout")
	public Integer doLoginOut(@CookieValue(name = ConfigUtil.COOKIE_NAME, required = false) String cookieValue,
			HttpSession session, HttpServletResponse response) {
		System.out.println("cookieValue" + cookieValue);
		session.setAttribute(ConfigUtil.LOGINOUT_ISREMENBER, cookieValue != null ? 1 : 0);
		session.removeAttribute(ConfigUtil.SESSION_LOGIN_USER_NAME);

		// 退出自动登录
		Cookie cookie = new Cookie(ConfigUtil.COOKIE_NAME,null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
		return 1;
	}
}
