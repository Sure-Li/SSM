package com.situ.springbind.role.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.situ.springbind.role.dao.RoleDao;
import com.situ.springbind.role.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {
	/**
	 * spring依赖注入
	 *  1.名称注入
	 *  2.类型注入
	 *  首先按照名称查找 然后类型查找 然后都找不到就报错
	 */
	@Resource //会自动去类中找roleDao的实例
	private RoleDao roleDao;
}
