/**
 * @Company:度半 
 * @Title:User.java 
 * @Author:Sure-Li  
 * @Date:2020-12-17 10:45:00     
 */
package com.situ.ssm.user.pojo;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.situ.ssm.base.pojo.BaseClass;

/**
 * @ClassName:User
 * @Description:(用户类)
 */
@Alias("User")
public class User extends BaseClass implements Serializable {
	public static final int IS_LOCK_NO = 0;
	public static final int IS_LOCK_YES = 1;
	private static final long serialVersionUID = 1L;
	private String userName;// 用户姓名
	private String userCode;// 用户账号
	private String userPassword;// 用户密码
	private String userAvatar;// 用户头像
	private Integer loginCount;// 登录次数
	private String lastLoginIp;// 最后登录IP
	private Date lastLoginDate;// 最后登录时间
	private Integer isLock;// 是否锁定 1是0否 不让登陆

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserAvatar() {
		return userAvatar;
	}

	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}

	public Integer getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Integer getIsLock() {
		return isLock;
	}

	public void setIsLock(Integer isLock) {
		this.isLock = isLock;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userCode=" + userCode + ", userPassword=" + userPassword
				+ ", userAvatar=" + userAvatar + ", loginCount=" + loginCount + ", lastLoginIp=" + lastLoginIp
				+ ", lastLoginDate=" + lastLoginDate + ", isLock=" + isLock + "]";
	}
}
