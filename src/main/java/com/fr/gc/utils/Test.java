package com.fr.gc.utils;

import com.fr.gc.dao.PersonneDao;
import com.fr.gc.dao.impl.GenericDaoImpl;
import com.fr.gc.dao.impl.PersonneDaoImpl;
import com.fr.gc.entities.Personne;

public class Test {

	public static void main(String[] args) {
		
		
		Personne personne = new Personne("145", "salah", "ahh", "ahha", "hhh");
		Personne personne1 = new Personne("1475", "salah", "aohh", "ahoha", "hohh");
		PersonneDao personneDao = new PersonneDaoImpl();
		
		try {
			personneDao.findById(personne.getCin());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		//with couplage
		PersonneDaoImpl personneDaoImpl = new PersonneDaoImpl() ;
		try {
			personneDaoImpl.save(personne);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//polymo interface for couplage fort/faible
		PersonneDao personneDao = new PersonneDaoImpl();
		
		try {
			personneDao.save(personne1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
