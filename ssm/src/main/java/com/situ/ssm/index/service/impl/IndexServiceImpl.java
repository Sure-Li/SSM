/**
 * @Company:度半 
 * @Title:IndexServiceImpl.java 
 * @Author:Sure-Li  
 * @Date:2020-12-18 14:57:04     
 */
package com.situ.ssm.index.service.impl;

import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CookieValue;

import com.situ.ssm.index.service.IndexService;
import com.situ.ssm.user.dao.UserDao;
import com.situ.ssm.user.pojo.User;
import com.situ.ssm.util.ConfigUtil;
import com.situ.ssm.util.MD5Util;

/**
 * @ClassName:IndexServiceImpl
 * @Description:(这里用一句话描述这个类的作用)
 */
@Service("indexService")
public class IndexServiceImpl implements IndexService {
	@Autowired
	private UserDao userDao;

	/**
	 * @Title: doLogin
	 * @Description:(这里用一句话描述这个方法的作用)
	 * @param userCode
	 * @param userPassword
	 * @param session
	 * @param response     用于cookie
	 * @return
	 */
	@Override
	public Integer doLogin(String userCode, String userPassword, String isRemenber, HttpServletRequest request,
			HttpServletResponse response) {
		int result = 0;
		// 对用户密码进行md5加密 然后再去数据库里查询
		String userEncodePassword = MD5Util.encode(userPassword);
		User user = userDao.selectByCodeAndPassword(userCode, userEncodePassword);
		if (user != null) {
			if (user.getIsLock() == User.IS_LOCK_NO) {
				user.setLoginCount(user.getLoginCount() + 1);
				user.setLastLoginDate(new Date());
				System.out.println("user.getLastLoginDate()" + user.getLastLoginDate());
				user.setLastLoginIp(request.getRemoteAddr());
				userDao.update(user);
				// 向session中放实例
				HttpSession session = request.getSession();
				session.setAttribute(ConfigUtil.SESSION_LOGIN_USER_NAME, user);
//				处理自动登录
				if (isRemenber != null && isRemenber.equals("on")) {
					StringBuilder cookieVaule = new StringBuilder();
					cookieVaule.append(user.getUserCode()).append(ConfigUtil.COOKIE_VALUE_SPLIT)
							.append(user.getRowId());
					Cookie cookie = new Cookie(ConfigUtil.COOKIE_NAME, cookieVaule.toString());
					cookie.setMaxAge(60 * 60 * 24 * 7);
					cookie.setPath("/");
					response.addCookie(cookie);
				}else {
					Cookie cookie = new Cookie(ConfigUtil.COOKIE_NAME,"");
					cookie.setMaxAge(0);
					cookie.setPath("/");
					response.addCookie(cookie);
				}
				result = 1;
			} else {
				result = 3;
			}
		} else {
			result = 2;
		}
		return result;
	}

	/** 
	 * @Title: autoLogin 
	 * @Description:(这里用一句话描述这个方法的作用)
	 * @param cookieValue
	 * @param session  
	 */  
	@Override
	public void autoLogin(String cookieValue, HttpServletRequest  request) {
		String[] arrayStrings = cookieValue.split(ConfigUtil.COOKIE_VALUE_SPLIT);
		System.out.println(Arrays.toString(arrayStrings));
		String userCode = arrayStrings[0];
		Long rowId = Long.parseLong(arrayStrings[1]);
		User user = userDao.selectByCodeAndRowId(userCode, rowId);
		System.out.println("---------------"+user+userCode+rowId);//----------------------------------------------------
		if (user!=null) {
			user.setLoginCount(user.getLoginCount()+1);
			user.setLastLoginIp(request.getRemoteAddr());
			user.setLastLoginDate(new Date());
			userDao.update(user);
			HttpSession session = request.getSession();
			session.setAttribute(ConfigUtil.SESSION_LOGIN_USER_NAME, user);
		}
		
	}

}
