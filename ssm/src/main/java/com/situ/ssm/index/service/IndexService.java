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

/** 
 * @ClassName:IndexService 
 * @Description:(首页的服务层)  
 */
public interface IndexService {
	Integer doLogin(String userCode,String userPassword, HttpServletRequest request,HttpServletResponse response);
}
