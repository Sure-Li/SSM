package com.situ.spring.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;

import com.situ.spring.Axe;
import com.situ.spring.test.MainTest;

public class SteeleAxe implements Axe {
	List<Integer> testList;
	private Map<String, Integer> testMap;
	
	public Map<String, Integer> getTestMap() {
		return testMap;
	}
	public void setTestMap(Map<String, Integer> testMap) {
		this.testMap = testMap;
	}

	private  Integer initNumber;
	public Integer getInitNumber() {
		return initNumber;
	}
	public void setInitNumber(Integer initNumber) {
		this.initNumber = initNumber;
	}
	private SteeleAxe() {
		System.out.println("SteeleAxe构造函数");
	}
	public void info() {
		System.out.println("这是一把钢斧");
	}
	public List<Integer> getTestList() {
		return testList;
	}
	public void setTestList(List<Integer> testList) {
		this.testList = testList;
	}
	public void testInitMethod() {
		
		LoggerFactory.getLogger(SteeleAxe.class).debug("系统初始化方法");
		LoggerFactory.getLogger(SteeleAxe.class).debug(initNumber+"initNumber");
		LoggerFactory.getLogger(SteeleAxe.class).debug("testList" +testList.toString());
		LoggerFactory.getLogger(SteeleAxe.class).debug("testMap"+testMap.toString());
	}

	public void excute() {
		System.out.println("使用斧子去干活");
	}

}
