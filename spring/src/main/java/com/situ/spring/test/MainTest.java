package com.situ.spring.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.situ.spring.Axe;
import com.situ.spring.person.Person;

/*import com.situ.spring.Axe;
import com.situ.spring.impl.StoneAxe;*/

public class MainTest {
	private static Long test = 0L;

	public static void main(String[] args) {

//		Logger log = LoggerFactory.getLogger(MainTest.class);
		/*
		 * Axe axe = new StoneAxe() ; ApplicationContext applicationContext = new
		 * ClassPathXmlApplicationContext("spring\\spring-context.xml");
		 * log.debug("1111");
		 * 
		 * System.out.println(applicationContext); Axe axe1 = (Axe)
		 * applicationContext.getBean(Axe.class); Axe axe2 = (Axe)
		 * applicationContext.getBean(Axe.class); Axe axe3 = (Axe)
		 * applicationContext.getBean(Axe.class);
		 * 
		 * // axe.info(); // Person person = (Person)
		 * applicationContext.getBean(Person.class); // person.work();
		 */
		System.out.println(test);
	}

}
