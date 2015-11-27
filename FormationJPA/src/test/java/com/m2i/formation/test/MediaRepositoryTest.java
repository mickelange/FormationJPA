package com.m2i.formation.test;

import static org.junit.Assert.*;
import java.util.List;
import javax.persistence.Query;
import org.junit.Assert;
import org.junit.Test;

import com.m2i.formation.media.entities.Media;
import com.m2i.formation.repositories.EMFSingleton;
import com.m2i.formation.repositories.Media2Repository;
import com.m2i.formation.repositories.MediaRepository;

public class MediaRepositoryTest {

	private Media2Repository mediaRepo;
	private Media mediaResult; 
	private List<Media> listeResult;

	@Test
	public void getByIdTest() {

		mediaRepo = new Media2Repository();
		mediaRepo.setEntityManager(EMFSingleton.getInstance().createEntityManager());
		mediaResult =  mediaRepo.getById(1);
		Assert.assertEquals(1,(int)mediaResult.getId());	
	}

	/*@Test
	public void saveRemoveTest() {

		mediaRepo = new Media2Repository();
		mediaRepo.setEntityManager(EMFSingleton.getInstance().createEntityManager());
		Query tq= mediaRepo.getEntityManager().createQuery("select count(m) from Media m");
		long nbMediasBefore =(long) tq.getSingleResult();
		Media m = new Media();
		m.setTitle("le chateau de hurle");
		m.setNumISBN(456789);
		m.setId_Publisher(1);
		m.setPrice((float) 9.50);
		m.setNbPages(124);
		m.setCategory(1);
		mediaRepo.save(m);
		long nbMediasAfter =(long) tq.getSingleResult();
		Assert.assertEquals(nbMediasAfter,nbMediasBefore +1);
		//remove
		mediaRepo.remove(m);
		nbMediasAfter =(long) tq.getSingleResult();
		Assert.assertEquals(nbMediasAfter,nbMediasBefore -1);	
	}*/

	@Test
	public void removeTest() {

		mediaRepo = new Media2Repository();
		mediaRepo.setEntityManager(EMFSingleton.getInstance().createEntityManager());
		Query tq= mediaRepo.getEntityManager().createQuery("select count(m) from Media m");
		long nbMediasBefore =(long) tq.getSingleResult();
		mediaResult =  mediaRepo.getById(20);
		mediaRepo.remove(mediaResult);
		mediaRepo.commit();
		long nbMediasAfter =(long) tq.getSingleResult();
		Assert.assertEquals(nbMediasAfter,nbMediasBefore -1);			
	}
}

