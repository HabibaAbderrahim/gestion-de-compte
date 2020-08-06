package com.fr.gc.services.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.fr.gc.dao.PersonneDao;
import com.fr.gc.dao.impl.PersonneDaoImpl;
import com.fr.gc.entities.Personne;
import com.fr.gc.model.MessageResponse;
import com.fr.gc.services.PersonneService;

public class PersonneServiceImpl implements PersonneService {

	private PersonneDao personneDao = new PersonneDaoImpl();

	@Override
	public MessageResponse save(Personne personne) throws Exception {

		if (personneDao.findById(personne.getCin()) != null) {
			return new MessageResponse(false, "CIN existant");

		}
		Criterion Crit = Restrictions.eq("email", personne.getEmail());
		List<Personne> list = personneDao.findByCriteria(Crit);
		if(!list.isEmpty()) {
			return new MessageResponse(false, "email existant");

		}
		personneDao.save(personne);
		return new MessageResponse(true,"Operation save effectuéé avec succés");

	}

	@Override
	public MessageResponse update(Personne personne) throws Exception {

		return null;
	}

	@Override
	public MessageResponse delete(Personne personne) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Personne> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
