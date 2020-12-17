/**
 * @Company:度半 
 * @Title:UserController.java 
 * @Author:Sure-Li 
 * @Date:2020-12-17 11:17:03     
 */
package com.situ.ssm.user.controller;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.situ.ssm.user.pojo.User;
import com.situ.ssm.user.service.UserService;
import com.situ.ssm.util.ServletUtil;

/**
 * @ClassName:UserController
 * @Description:(用户控制层)
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping
	public ModelAndView goIndex(ModelAndView modelAndView) {
		modelAndView.setViewName("/user/user_index");
		return modelAndView;
	}

	@GetMapping("/form")
	public ModelAndView goAddForm(ModelAndView modelAndView) {
		modelAndView.setViewName("/user/user_add");
		return modelAndView;
	}

	@RequestMapping("/upload")
	public String upload(MultipartFile userFile, HttpServletRequest request) {
		String realPath = request.getServletContext().getRealPath("/");
		return userService.doUploadAvatar(userFile, realPath);
		
	}
	@PostMapping
	public Integer doAddUser(User user,HttpSession session) {
		String createBy = ServletUtil.getUserCodeBySession(session);
		return userService.doAddUser(user,createBy);
	}
}
