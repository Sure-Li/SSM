package com.situ.springbind.role.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.situ.springbind.role.dao.impl.RoleDaoImpl;

public class MainTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring\\springMVC-config.xml");
//		按照名称查找
//		@Repository 默认的roleDaoImpl
//		Object obj = applicationContext.getBean("roleDaoImpl");
//		@Repository("AAAA") 使用别名进行查找的
//		Object obj1 = applicationContext.getBean("AAAA");
		//按照类型查找
//		Object obj2 = applicationContext.getBean(RoleDaoImpl.class);
//		System.out.println(obj);
//		System.out.println(obj1);
//		System.out.println(obj2);
	}

}
