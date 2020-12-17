/**
 * @Company:度半 
 * @Title:UserServiceImpl.java 
 * @Author:Sure-Li  
 * @Date:2020-12-17 11:15:59     
 */
package com.situ.ssm.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.ssm.user.dao.UserDao;
import com.situ.ssm.user.service.UserService;

/**
 * @ClassName:UserServiceImpl
 * @Description:(UserServiceImpl)
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
}
