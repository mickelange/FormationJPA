package com.m2i.formation.repositories;

import javax.persistence.*;

public interface IUoW {
	
	void commit();
	EntityTransaction getTransaction();
	
	void setTransaction(EntityTransaction transaction);
	
	EntityManager getEntityManager();
	
	void setEntityManager(EntityManager em);
	

}
