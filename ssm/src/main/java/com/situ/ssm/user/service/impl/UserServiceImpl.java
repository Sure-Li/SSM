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
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
	private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(UserService.class);
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
				stringBuilder.append(realPath).append(ConfigUtil.PATH_AVATAR).append("/")
						.append(Calendar.getInstance().getTimeInMillis()).append(fileSuffix);
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
	@Transactional // 可以修饰类和方法
	public Integer doAddUser(User user, String createBy) {
		// 打开事务
		user.setUserPassword(MD5Util.encode(user.getUserPassword()));
		user.setLoginCount(0);
		user.setIsLock(User.IS_LOCK_NO);
		user.setActiveFlag(1);
		user.setCreateBy(createBy);
		user.setCreateDate(new Date());
		// 模拟一个部门员工数量的更新

		return userDao.save(user);

		// 如果多条sql语句运行没有问题 则提交commit
		// 否则回滚rollback
	}

	/**
	 * @Title: findUserBySearch
	 * @Description:(这里用一句话描述这个方法的作用)
	 * @return
	 */
	@Override
	public List<User> findUserBySearch(User searchUser) {
		return userDao.findUserBySearch(searchUser);
	}

	/**
	 * @Title: findUserByRowId
	 * @Description:(这里用一句话描述这个方法的作用)
	 * @param rowId
	 * @return
	 */
	@Override
	public User findUserByRowId(Long rowId) {
		return userDao.findUserByRowId(rowId);
	}

	/**
	 * @Title: update
	 * @Description:(修改用户信息)
	 * @param user
	 * @return
	 */
	@Override
	public Integer update(User user) {
		User userGet = findUserByRowId(user.getRowId());
		userGet.setUserName(user.getUserName());
		if (user.getUserPassword() != "" && user.getUserPassword() != null) {
			userGet.setUserPassword(MD5Util.encode(user.getUserPassword()));
		}
		if (user.getUserAvatar() != "" && user.getUserAvatar() != null) {
			userGet.setUserAvatar(user.getUserAvatar());
		}
		userGet.setIsLock(user.getIsLock());
		return userDao.update(userGet);
	}

	/**
	 * @Title: delete
	 * @Description:(这里用一句话描述这个方法的作用)
	 * @param rowId
	 * @return
	 */
	@Override
	public Integer delete(Long rowId) {
		User userGet = findUserByRowId(rowId);
		userGet.setActiveFlag(0);
		return userDao.update(userGet);
	}

	/**
	 * @Title: initUSerData
	 * @Description:(这里用一句话描述这个方法的作用)
	 */
	@PostConstruct // 修饰的就类似于spring容器里的init-method
	@Override
	public void initUSerData() {
//		LOG.debug("@PostConstruct//修饰的就类似于spring容器里的init-method\n" + 
//				"	@Override");
		List<User> userList = userDao.selectAll();
		if (userList == null || userList.size() == 0) {
			User user = new User();
			user.setActiveFlag(1);
			user.setCreateBy("admin");
			user.setCreateDate(new Date());
			user.setIsLock(0);
			user.setUserCode("admin");
			user.setUserName("管理员");
			user.setUserPassword(MD5Util.encode("123456"));
			user.setLoginCount(0);
			userDao.save(user);
		}
	}

}
