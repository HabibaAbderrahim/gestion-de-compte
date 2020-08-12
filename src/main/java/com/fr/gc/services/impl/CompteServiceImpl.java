package com.fr.gc.services.impl;

import java.util.List;

import com.fr.gc.dao.CompteDao;
import com.fr.gc.dao.impl.CompteDaoImpl;
import com.fr.gc.entities.Compte;
import com.fr.gc.model.MessageResponse;
import com.fr.gc.services.CompteService;

public class CompteServiceImpl implements CompteService {

	private CompteDao compteDao = new CompteDaoImpl();

	@Override
	public MessageResponse save(Compte compte) throws Exception {
		compteDao.save(compte);
		return new MessageResponse(true, "Opération effectuée avec succés");
	}

	@Override
	public MessageResponse update(Compte compte) throws Exception {
		compteDao.update(compte);
		return new MessageResponse(true, "Opération effectuée avec succés");
	}

	@Override
	public MessageResponse delete(Compte compte) throws Exception {
		compteDao.delete(compte);
		return new MessageResponse(true, "Opération effectuée avec succés");
	}

	@Override
	public List<Compte> findAll() throws Exception {

		return compteDao.findAll();
	}

}
