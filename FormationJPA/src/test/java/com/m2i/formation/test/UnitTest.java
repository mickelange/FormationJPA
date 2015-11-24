package com.m2i.formation.test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Assert;
import org.junit.Test;

import com.m2i.formation.media.entities.Media;
import com.m2i.formation.repositories.EMFSingleton;

public class UnitTest {

	@Test
	public void entityManagerTest() {
		EntityManagerFactory emf = EMFSingleton.getInstance();
		assertNotNull(emf);
		EntityManager em = emf.createEntityManager();
		assertNotNull(em);
		
	}
	
	@Test
	public void MediaTest() {
		EntityManagerFactory emf = EMFSingleton.getInstance();
		EntityManager em = emf.createEntityManager();
		Media m = em.find(Media.class, 1);
		assertNotNull(m);
		Assert.assertEquals(1,m.getId() );		
	}

}
