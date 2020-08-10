package com.fr.gc.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import com.fr.gc.entities.Personne;
import com.fr.gc.services.PersonneService;
import com.fr.gc.services.impl.PersonneServiceImpl;

@ManagedBean
@ViewScoped
public class PersonneBean implements Serializable {

	private Personne personne = new Personne();
	private PersonneService personneService = new PersonneServiceImpl();
	private List<Personne> list = new ArrayList<>();

	public void ajouter() {

		try {
			personneService.save(personne);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public List<Personne> getList() {
		try {
			list = personneService.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public void setList(List<Personne> list) {
		this.list = list;
	}

}