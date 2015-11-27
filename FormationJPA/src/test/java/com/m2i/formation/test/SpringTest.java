package com.m2i.formation.test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.m2i.formation.media.entities.*;
import com.m2i.formation.media.services.MainService;
import com.m2i.formation.repositories.*;

public class SpringTest {

	//private XmlBeanFactory beanFactory=null;
	@Test
	public void InitialisationTest() {
	
		//beanFactory= SpringSingleton.getInstance();
		
		Media2Repository mediaRepo = (Media2Repository)SpringSingleton.getInstance().getBean("mediaRepository");
		mediaRepo.setEntityManager(EMFSingleton.getInstance().createEntityManager());
		Media m = mediaRepo.getById(1);
		assertEquals(1,(int)m.getId());
		
		//
		Media2Repository mediaRepo2 = SpringSingleton.getInstance().getBean("mediaRepository",Media2Repository.class);
		mediaRepo2.setEntityManager(EMFSingleton.getInstance().createEntityManager());
		Media m2 = mediaRepo2.getById(2);
		assertEquals(2,(int)m2.getId());
	
	}
	
	@Test
	public void Initialisation2Test() {
		
		MainService main = SpringSingleton.getInstance().getBean("mainService",MainService.class);
		assertNotNull(main);
		assertNotNull(main.getAuthorRepository());
		assertNotNull(main.getMediaRepository());
		
	}

}
