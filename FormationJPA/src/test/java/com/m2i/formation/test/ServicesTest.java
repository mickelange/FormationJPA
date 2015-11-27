package com.m2i.formation.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.m2i.formation.media.entities.*;
import com.m2i.formation.media.services.*;
import com.m2i.formation.repositories.*;


public class ServicesTest {

	private Media2Repository mediaRepo;
	private Media mediaResult; 
	private AuthorRepository authorRepo;
	private Author authorResult;
	@Test
	public void addAuthorToMediaTest() throws ServiceException {
		
		mediaRepo = new Media2Repository();
		mediaRepo.setEntityManager(EMFSingleton.getInstance().createEntityManager());
		authorRepo = new AuthorRepository();
		authorRepo.setEntityManager(EMFSingleton.getInstance().createEntityManager());
		authorResult = authorRepo.getById(1);
		mediaResult = mediaRepo.getById(2);
		MainService service = new MainService();
		service.addAuthorToMedia(authorResult, mediaResult.getId());
		Assert.assertTrue(mediaResult.getAuthors().contains(authorResult));
	}

}
