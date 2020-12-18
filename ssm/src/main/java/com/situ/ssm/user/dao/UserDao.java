/**
 * @Company:度半 
 * @Title:UserDao.java 
 * @Author:Sure-Li  
 * @Date:2020-12-17 10:55:22     
 */
package com.situ.ssm.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.situ.ssm.base.dao.BaseDao;
import com.situ.ssm.user.pojo.User;

/**
 * @ClassName:UserDao
 * @Description:(这里用一句话描述这个类的作用)
 */
@Repository("userDao") // 制定是一个好习惯 可以用于代码混淆
public interface UserDao extends BaseDao<User> {

	/**
	 * @Title: findUserBySearch
	 * @Description:(这里用一句话描述这个方法的作用)
	 * @param userSeach
	 * @return
	 */
	List<User> findUserBySearch(User searchUser);

	/**
	 * 
	 * @Title: selectByCodeAndPassWord
	 * @Description:(这里用一句话描述这个方法的作用)
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	User selectByCodeAndPassword(@Param("userCode") String userCode, @Param("userPassword") String userPassword);
}
