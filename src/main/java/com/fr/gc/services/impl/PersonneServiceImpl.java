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
		if (!list.isEmpty()) {
			return new MessageResponse(false, "email existant");

		}
		personneDao.save(personne);
		return new MessageResponse(true, "Operation save effectu�� avec succ�s");

	}

	@Override
	public MessageResponse update(Personne personne) throws Exception {

		Criterion crit1 = Restrictions.idEq(personne.getCin());
		Criterion crit2 = Restrictions.eq("email", personne.getEmail());
		Criterion crit = Restrictions.and(crit1, crit2);
		List<Personne> list = personneDao.findByCriteria(crit);

		if (list.isEmpty()) {
			// lawej bel email
			list = personneDao.findByCriteria(crit2);
			if (!list.isEmpty()) {
				return new MessageResponse(false, "email existant");
			}

		}

		personneDao.update(personne);
		return new MessageResponse(false, "email existant");
	}

	@Override
	public MessageResponse delete(Personne personne) throws Exception {
		
		//a condition persoonnee aandouch compte
		
		
		Criterion Crit= Restrictions.isNotEmpty("comptes");
		List<Personne>list = personneDao.findByCriteria(Crit);
		
		if(!list.isEmpty()) {
			return new MessageResponse(false,"Personne a un ou plusieurs comptes !!!");
		}
		personneDao.delete(personne);
		return new MessageResponse(false,"operation effectu�e avc succeess");
	}

	@Override
	public List<Personne> findAll() throws Exception {
	
		return personneDao.findAll();
	}

}
