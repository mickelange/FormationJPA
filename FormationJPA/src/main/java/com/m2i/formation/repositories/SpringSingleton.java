package com.m2i.formation.repositories;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class SpringSingleton {
	
	private static ApplicationContext instance = null; 
	
	public static final ApplicationContext getInstance(){
		if( instance == null){
		instance = new ClassPathXmlApplicationContext("spring.xml");
		}
		return instance;	
	}

	private SpringSingleton() {
		
	}

}
