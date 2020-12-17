/**
 * @Company:度半 
 * @Title:UserDao.java 
 * @Author:Sure-Li  
 * @Date:2020-12-17 10:55:22     
 */ 
package com.situ.ssm.user.dao;

import org.springframework.stereotype.Repository;

import com.situ.ssm.base.dao.BaseDao;
import com.situ.ssm.user.pojo.User;

/** 
 * @ClassName:UserDao 
 * @Description:(这里用一句话描述这个类的作用)  
 */
@Repository("userDao")//制定是一个好习惯 可以用于代码混淆
public interface UserDao extends BaseDao<User> {

}
