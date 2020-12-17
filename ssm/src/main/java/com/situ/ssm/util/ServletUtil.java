/**
 * @Company:度半 
 * @Title:ServletUtil.java 
 * @Author:Sure-Li  
 * @Date:2020-12-17 16:21:45     
 */
package com.situ.ssm.util;

import javax.servlet.http.HttpSession;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import com.situ.ssm.user.pojo.User;

/**
 * @ClassName:ServletUtil
 * @Description:(这里用一句话描述这个类的作用)
 */
public class ServletUtil {
	public static String getUserCodeBySession(HttpSession session) {
		User user = getUserBySession(session);
		if (user != null) {
			return user.getUserCode();
		}
		return null;

	}

	public static User getUserBySession(HttpSession session) {
		Object object = session.getAttribute(ConfigUtil.SESSION_LOGIN_USER_NAME);
		if (object != null) {
			return (User) object;
		}
		return null;
	}
}
