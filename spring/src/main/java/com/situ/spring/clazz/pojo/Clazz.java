package com.situ.spring.clazz.pojo;

import java.io.Serializable;

public class Clazz implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long rowId;
	private Integer clazzId;
	private String clazzName;
	private Integer clazzStudentCount;
	private String clazzInfo;
	private Integer activeFlag;

	public Clazz(Long rowId, Integer clazzId, String clazzName, Integer clazzStudentCount, String clazzInfo,
			Integer activeFlag) {
		super();
		this.rowId = rowId;
		this.clazzId = clazzId;
		this.clazzName = clazzName;
		this.clazzStudentCount = clazzStudentCount;
		this.clazzInfo = clazzInfo;
		this.activeFlag = activeFlag;
	}

	public Integer getClazzId() {
		return clazzId;
	}

	public void setClazzId(Integer clazzId) {
		this.clazzId = clazzId;
	}

	public Long getRowId() {
		return rowId;
	}

	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}

	public String getClazzName() {
		return clazzName;
	}

	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
	}

	public Integer getClazzStudentCount() {
		return clazzStudentCount;
	}

	public void setClazzStudentCount(Integer clazzStudentCount) {
		this.clazzStudentCount = clazzStudentCount;
	}

	public String getClazzInfo() {
		return clazzInfo;
	}

	public void setClazzInfo(String clazzInfo) {
		this.clazzInfo = clazzInfo;
	}

	public Integer getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Integer activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Clazz(Long rowId, String clazzName, Integer clazzStudentCount, String clazzInfo, Integer activeFlag) {
		super();
		this.rowId = rowId;
		this.clazzName = clazzName;
		this.clazzStudentCount = clazzStudentCount;
		this.clazzInfo = clazzInfo;
		this.activeFlag = activeFlag;
	}

	public Clazz(String clazzName, Integer clazzStudentCount, String clazzInfo, Integer activeFlag) {
		super();
		this.clazzName = clazzName;
		this.clazzStudentCount = clazzStudentCount;
		this.clazzInfo = clazzInfo;
		this.activeFlag = activeFlag;
	}

	@Override
	public String toString() {
		return "Clazz [rowId=" + rowId + ", clazzName=" + clazzName + ", clazzStudentCount=" + clazzStudentCount
				+ ", clazzInfo=" + clazzInfo + ", activeFlag=" + activeFlag + "]";
	}

	public Clazz() {
		super();
	}
}
