package com.fr.gc.services;

import java.util.List;

import com.fr.gc.entities.Personne;
import com.fr.gc.model.MessageResponse;

public interface PersonneService {
	
	public MessageResponse save(Personne personne) throws Exception;
	public MessageResponse update(Personne personne) throws Exception;
	public MessageResponse delete(Personne personne) throws Exception;

	public List<Personne> findAll() throws Exception;

}
