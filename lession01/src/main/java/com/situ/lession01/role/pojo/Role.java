package com.situ.lession01.role.pojo;

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long rowId;
	private Integer roleType;
	private String roleName;
	private String roleInfo;
	private Integer activeFlag;
	private String createBy;
	private Date createDate;
	private String updateBy;
	private Date updateDate;
	public Long getRowId() {
		return rowId;
	}
	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}
	public Integer getRoleType() {
		return roleType;
	}
	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleInfo() {
		return roleInfo;
	}
	public void setRoleInfo(String roleInfo) {
		this.roleInfo = roleInfo;
	}
	public Integer getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(Integer activeFlag) {
		this.activeFlag = activeFlag;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Role() {
		super();
	}
	public Role(Long rowId, Integer roleType, String roleName, String roleInfo, Integer activeFlag, String createBy,
			Date createDate, String updateBy, Date updateDate) {
		super();
		this.rowId = rowId;
		this.roleType = roleType;
		this.roleName = roleName;
		this.roleInfo = roleInfo;
		this.activeFlag = activeFlag;
		this.createBy = createBy;
		this.createDate = createDate;
		this.updateBy = updateBy;
		this.updateDate = updateDate;
	}
	@Override
	public String toString() {
		return "Role [rowId=" + rowId + ", roleType=" + roleType + ", roleName=" + roleName + ", roleInfo=" + roleInfo
				+ ", activeFlag=" + activeFlag + ", createBy=" + createBy + ", createDate=" + createDate + ", updateBy="
				+ updateBy + ", updateDate=" + updateDate + "]";
	}
	public Role(Integer roleType, String roleName) {
		super();
		this.roleType = roleType;
		this.roleName = roleName;
	}
	
	
}
