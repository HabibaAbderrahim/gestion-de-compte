package com.fr.gc.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import com.fr.gc.entities.Personne;

@ManagedBean
@ViewScoped
public class PersonneBean implements Serializable {

	private Personne personne = new Personne();

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	
	
}
