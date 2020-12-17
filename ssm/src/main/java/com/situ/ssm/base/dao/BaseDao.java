/**
 * @Company:度半 
 * @Title:BaseDao.java 
 * @Author:Sure-Li  
 * @Date:2020-12-17 10:48:35     
 */
package com.situ.ssm.base.dao;

import java.util.List;

/**
 * @ClassName:BaseDao
 * @Description:(基本的dao层)
 */
public interface BaseDao<T> {
	/**
	 * 
	 * @Title: save
	 * @Description:(保存一个对象)
	 * @param t
	 * @return 受影响的行数
	 */
	int save(T t);

	/**
	 * 
	 * @Title: update
	 * @Description:(更新一个对象)
	 * @param t
	 * @return 受影响的行数
	 */
	int update(T t);

	/**
	 * 
	 * @Title: delete
	 * @Description:(删除一个对象)
	 * @param rowId 要删除的主键
	 * @return 受影响的行数
	 */
	int delete(Long rowId);

	/**
	 * 
	 * @Title: selectOne
	 * @Description:(根据主键查询一个对象)
	 * @param rowId 要查询主键
	 * @return 返回查询得到的对象
	 */
	T selectOne(Long rowId);

	/**
	 * 
	 * @Title: selectAll
	 * @Description:(查询所有的对象)
	 * @return 查到的所有的对象
	 */
	List<T> selectAll();
}
