/**
 * @Company:度半 
 * @Title:BaseClass.java 
 * @Author:Sure-Li  
 * @Date:2020-12-17 10:43:54     
 */
package com.situ.ssm.base.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName:BaseClass
 * @Description:(基本类)
 */
public class BaseClass implements Serializable {
	private static final long serialVersionUID = 1L;
	protected Long rowId;//主键
	protected Integer activeFlag;//数据是否有效 1有效 0无效
	protected String createBy;//创建人
	protected Date createDate;//创建时间
	protected String updateBy;//修改人
	protected Date updateDate;//修改时间
	public Long getRowId() {
		return rowId;
	}
	public void setRowId(Long rowId) {
		this.rowId = rowId;
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
	
}
