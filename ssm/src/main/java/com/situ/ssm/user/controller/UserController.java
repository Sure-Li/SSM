/**
 * @Company:度半 
 * @Title:UserController.java 
 * @Author:Sure-Li  
 * @Date:2020-12-17 11:17:03     
 */
package com.situ.ssm.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.situ.ssm.user.service.UserService;

/**
 * @ClassName:UserController
 * @Description:(用户控制层)
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
}
