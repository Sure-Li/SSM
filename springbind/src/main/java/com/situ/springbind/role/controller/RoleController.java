package com.situ.springbind.role.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.situ.springbind.role.service.RoleService;

@Controller//("roleController")可写可不写 定义类的实例名 可以用来代码混淆
public class RoleController {
	@Autowired
	private RoleService roleService;
}
