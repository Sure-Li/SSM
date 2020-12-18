/**
 * @Company:度半 
 * @Title:IndexServiceImpl.java 
 * @Author:Sure-Li  
 * @Date:2020-12-18 14:57:04     
 */
package com.situ.ssm.index.service.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Integer doLogin(String userCode, String userPassword, HttpServletRequest request,
			HttpServletResponse response) {
		int result = 0;
		// 对用户密码进行md5加密 然后再去数据库里查询
		String userEncodePassword = MD5Util.encode(userPassword);
		User user = userDao.selectByCodeAndPassword(userCode, userEncodePassword);
		if (user != null) {
			if (user.getIsLock() == User.IS_LOCK_NO) {
				user.setLoginCount(user.getLoginCount() + 1);
				user.setLastLoginDate(new Date());
				System.out.println("user.getLastLoginDate()"+user.getLastLoginDate());
				user.setLastLoginIp(request.getRemoteAddr());
				userDao.update(user);
				// 向session中放实例
				HttpSession session = request.getSession();
				session.setAttribute(ConfigUtil.SESSION_LOGIN_USER_NAME, user);
				result = 1;
			} else {
				result = 3;
			}
		} else {
			result = 2;
		}
		return result;
	}

}
