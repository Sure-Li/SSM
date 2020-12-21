/**
 * @Company:度半 
 * @Title:UserService.java 
 * @Author:Sure-Li  
 * @Date:2020-12-17 11:15:28     
 */
package com.situ.ssm.user.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.situ.ssm.user.pojo.User;

/**
 * @ClassName:UserService
 * @Description:(这里用一句话描述这个类的作用)
 */
public interface UserService {
	/**
	 * 
	 * @Title: doUploadAvatar
	 * @Description:(上传用户头像)
	 * @param multipartFile
	 * @param realPath
	 * @return 上传文件相对路径
	 */
	String doUploadAvatar(MultipartFile multipartFile, String realPath);

	/**
	 * @Title: doAddUser
	 * @Description:(这里用一句话描述这个方法的作用)
	 * @param user
	 * @return
	 */
	Integer doAddUser(User user, String createBy);
	
	List<User> findUserBySearch(User searchUser);
	
	User findUserByRowId(Long rowId);

	/** 
	 * @Title: update 
	 * @Description:(这里用一句话描述这个方法的作用)
	 * @param user
	 * @return  
	 */ 
	Integer update(User user);

	/** 
	 * @Title: delete 
	 * @Description:(这里用一句话描述这个方法的作用)
	 * @param rowId
	 * @return  
	 */ 
	Integer delete(Long rowId);
	
	void initUSerData();

}
