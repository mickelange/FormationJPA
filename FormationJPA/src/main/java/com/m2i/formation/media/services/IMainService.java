package com.m2i.formation.media.services;

import com.m2i.formation.media.entities.Author;

public interface IMainService {

	void addAuthorToMedia(Author a, int mediaId) throws ServiceException;

}