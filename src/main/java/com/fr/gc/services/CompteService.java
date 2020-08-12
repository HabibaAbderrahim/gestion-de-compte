package com.fr.gc.services;

import java.util.List;

import com.fr.gc.entities.Compte;
import com.fr.gc.model.MessageResponse;

public interface CompteService {
	
	public MessageResponse save(Compte compte) throws Exception;
	public MessageResponse update(Compte compte) throws Exception;
	public MessageResponse delete(Compte compte) throws Exception;
	public List<Compte> findAll() throws Exception;

}
