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
	private boolean btnAdd = true, btnEdit = false;

	public void clickEdit() {
		
		btnEdit = true;
		btnAdd = false;
	}
	
	public void annuler() {
		personne = new Personne();
		btnAdd = true;
		btnEdit = false;
	}

	public void ajouter() {

		try {
			personneService.save(personne);
			// new object after
			personne = new Personne();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void modifier() {

		try {
			personneService.update(personne);
			personne = new Personne();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void supprimer() {

		try {
			personneService.delete(personne);
			personne = new Personne();
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

	public boolean isBtnAdd() {
		return btnAdd;
	}

	public void setBtnAdd(boolean btnAdd) {
		this.btnAdd = btnAdd;
	}

	public boolean isBtnEdit() {
		return btnEdit;
	}

	public void setBtnEdit(boolean btnEdit) {
		this.btnEdit = btnEdit;
	}

}
