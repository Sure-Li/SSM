package com.situ.lession01.dao;

import com.situ.lession01.role.pojo.Role;
/**
 * 持久化对象
 * 就有持久化能力
 * @return
 */
public interface RoleDao {
	int insert(Role role);
}
