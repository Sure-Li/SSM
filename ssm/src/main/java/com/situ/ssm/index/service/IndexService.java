/**
 * @Company:度半 
 * @Title:IndexService.java 
 * @Author:Sure-Li  
 * @Date:2020-12-18 14:56:25     
 */ 
package com.situ.ssm.index.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CookieValue;

/** 
 * @ClassName:IndexService 
 * @Description:(首页的服务层)  
 */
public interface IndexService {
	Integer doLogin(String userCode,String userPassword,String isRemenber, HttpServletRequest request,HttpServletResponse response);

	/** 
	 * @Title: autoLogin 
	 * @Description:(处理自动登录)
	 * @param cookieValue
	 * @param session  
	 */ 
	void autoLogin(String cookieValue, HttpServletRequest request);
}
