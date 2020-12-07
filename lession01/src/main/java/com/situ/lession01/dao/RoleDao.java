package com.situ.lession01.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.situ.lession01.role.pojo.Role;
/**
 * 持久化对象
 * 就有持久化能力
 * @return
 */
public interface RoleDao {
	/**
	 * 插入一条新数据
	 * @param role
	 * @return
	 */
	int insert(Role role);
	/**
	 * 查找一个实例
	 * @param rowId
	 * @return
	 */
	Role findOne(Long rowId);
	/**
	 * 查找所有的实例
	 * @return
	 */
	List<Role> findAll();
	/**
	 * 修改
	 * @param role
	 * @return
	 */
	int update(Role role);
	/**
	 * 删除
	 * @param rowId
	 * @return
	 */
	int delete(Long rowId);
	/**
	 * 使用名字和id查找到一个实例
	 * @param roleName
	 * @param rowId
	 * @return
	 */
	Role findOneByName(@Param("roleName")String roleName,@Param("rowId")Long rowId);
}
