package com.situ.spring.person;

import javax.annotation.Resource;

import org.slf4j.LoggerFactory;

import com.situ.spring.Axe;

public class Person {
//	依赖注入
	@Resource
	private Axe axe ;
	
	public Axe getAxe() {
		return axe;
	}
	private Axe axeStone;
	public Person(Axe axeStone) {
		LoggerFactory.getLogger(Person.class).debug("this.axeStone = axeStone;");
		this.axeStone = axeStone;
	}
	
	/*
	 * public void setAxe(Axe axe) { this.axe = axe; }
	 */
	public void work() {
		axe.excute();
	}
	
}
