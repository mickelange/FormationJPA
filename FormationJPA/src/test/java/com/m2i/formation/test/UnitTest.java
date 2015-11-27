package com.m2i.formation.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;


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
		Assert.assertEquals(1,(int)m.getId() );	
		Assert.assertEquals("Enquete dans le brouillard",m.getTitle() );
	}
	
	@Test
	public void InsertRemoveMediaTest() {
		EntityManagerFactory emf = EMFSingleton.getInstance();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		long nbMediasBefore =0;
		Query tq= em.createQuery("select count(m) from Media m");
		nbMediasBefore =(long) tq.getSingleResult();
		Media m = new Media();
		m.setTitle("le chateau de hurle");
		
		m.setNumISBN(456789);
		//m.setPublisher(publisher);lisher.(1);
		m.setPrice((float) 9.50);
		m.setNbPages(124);
		m.setCategory(1);
		em.persist(m);
		tx.commit();
		assertNotNull(m);
		tq= em.createQuery("select count(m) from Media m");
		long nbMediasafter =(long) tq.getSingleResult();
		Assert.assertEquals(nbMediasafter,nbMediasBefore+1);
		tx.begin();
		m.setPrice((float) 11.50);
		tq= em.createQuery("select count(m) from Media m where m.price<9");
		long nbMediasPrix =(long) tq.getSingleResult();
		Assert.assertEquals(4,nbMediasPrix);
		em.persist(m);
		em.remove(m);

		tx.commit();
		
	}

}
