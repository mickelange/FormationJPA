package com.m2i.formation.media.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.m2i.formation.media.entities.*;
import com.m2i.formation.repositories.*;

public class MainService implements IMainService {
	
	private Media2Repository mediaRepository;
	private AuthorRepository authorRepository;
	/**
	 * @return the mediaRepository
	 */
	public Media2Repository getMediaRepository() {
		return mediaRepository;
	}

	/**
	 * @param mediarepository the mediarepository to set
	 */
	public void setMediaRepository(Media2Repository mediarepository) {
		this.mediaRepository = mediarepository;
	}

	/**
	 * @return the authorRepository
	 */
	public AuthorRepository getAuthorRepository() {
		return authorRepository;
	}

	/**
	 * @param authorRepository the authorRepository to set
	 */
	public void setAuthorRepository(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}


	
	/* (non-Javadoc)
	 * @see com.m2i.formation.media.services.IMainService#addAuthorToMedia(com.m2i.formation.media.entities.Author, int)
	 */
	@Override
	public void addAuthorToMedia(Author a, int mediaId) throws ServiceException{
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FormationJPA");
		EntityManager em = emf.createEntityManager();
		mediaRepository = new Media2Repository();
		mediaRepository.setEntityManager(em);
		Media m = mediaRepository.getById(mediaId);
		if( m != null){
			if(!m.getAuthors().contains(a)){
				m.getAuthors().add(a);
				mediaRepository.getTransaction();
				mediaRepository.update(m);
				//mediarepository.save(m);
				mediaRepository.commit();
			}
			else {
				throw new ServiceException("Author already associate with this Media");
			}
		}
		else {
			throw new ServiceException("The media does not exist");	
		}
		
	}

}
