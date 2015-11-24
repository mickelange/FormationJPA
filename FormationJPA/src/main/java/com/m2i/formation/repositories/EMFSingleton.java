package com.m2i.formation.repositories;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFSingleton {
	
	private static EntityManagerFactory instance = null; 
	
	public static final EntityManagerFactory getInstance(){
		if( instance == null){
		instance = Persistence.createEntityManagerFactory("FormationJPA");
		}
		return instance;	
	}
	private EMFSingleton(){	
	}

}
