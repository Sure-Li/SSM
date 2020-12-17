/**
 * @Company:度半 
 * @Title:UserServiceImpl.java 
 * @Author:Sure-Li  
 * @Date:2020-12-17 11:15:59     
 */
package com.situ.ssm.user.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.situ.ssm.user.dao.UserDao;
import com.situ.ssm.user.pojo.User;
import com.situ.ssm.user.service.UserService;
import com.situ.ssm.util.ConfigUtil;
import com.situ.ssm.util.MD5Util;

/**
 * @ClassName:UserServiceImpl
 * @Description:(UserServiceImpl)
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	/**
	 * 
	 * @Title: doUploadAvatar 
	 * @Description:(上传用户头像)
	 * @param multipartFile
	 * @param realPath
	 * @return 上传文件相对路径
	 */ 
	@Override
	public String doUploadAvatar(MultipartFile multipartFile, String realPath) {
		System.out.println("stuFile:" + multipartFile);
		StringBuilder stringBuilder = new StringBuilder();
		if (!multipartFile.isEmpty()) {// 判断不为空
			try {
				String fileSuffix = multipartFile.getOriginalFilename()
						.substring(multipartFile.getOriginalFilename().lastIndexOf("."));
				stringBuilder.append(realPath).append(ConfigUtil.PATH_AVATAR).append("/").append(Calendar.getInstance().getTimeInMillis())
						.append(fileSuffix);
				File outFile = new File(stringBuilder.toString());
				File getParentFile = outFile.getParentFile();
				if (!getParentFile.exists()) {
					getParentFile.mkdirs();
				}
				multipartFile.transferTo(new File(stringBuilder.toString()));
				System.out.println(stringBuilder);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return stringBuilder.toString();
	}

	/** 
	 * @Title: doAddUser 
	 * @Description:(这里用一句话描述这个方法的作用)
	 * @param user
	 * @return  
	 */  
	@Override
	public Integer doAddUser(User user,String createBy) {
		user.setUserPassword(MD5Util.encode(user.getUserPassword()));
		user.setLoginCount(0);
		user.setIsLock(User.IS_LOCK_NO);
		user.setActiveFlag(1);
		user.setCreateBy(createBy);
		user.setCreateDate(new Date());
		return userDao.save(user);
	}
}
