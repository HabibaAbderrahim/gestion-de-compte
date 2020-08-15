package com.fr.gc.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.fr.gc.entities.Compte;
import com.fr.gc.model.MessageResponse;
import com.fr.gc.services.CompteService;
import com.fr.gc.services.impl.CompteServiceImpl;

@ManagedBean
@ViewScoped
public class CompteBean implements Serializable {

	// objet compte fel vue bech tsob compte so u nned compte fel contr
	private Compte compte = new Compte();
	private CompteService compteService = new CompteServiceImpl();
	private List<Compte> list = new ArrayList<>();
	private boolean btnAdd=true, btnEdit=false ;
	
	public void clickEdit() {
		btnAdd=false ;
		btnEdit=true;
	}

	public void ajouter() {
		try {
			MessageResponse result = compteService.save(compte);
			compte = new Compte();
			if (result.isSuccess()) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", result.getMessage()));

			} else {

				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention", result.getMessage()));

			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Opération non effectuée"));
			e.printStackTrace();
		}
	}

	public void supprimer() {
		try {
			MessageResponse result = compteService.delete(compte);
			if (result.isSuccess()) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", result.getMessage()));

			} else {

				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention", result.getMessage()));

			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Opération non effectuée"));
			e.printStackTrace();
		}
	}
	
	public void modifier() {
		try {
			MessageResponse result = compteService.update(compte);
			if (result.isSuccess()) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", result.getMessage()));

			} else {

				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention", result.getMessage()));

			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Opération non effectuée"));
			e.printStackTrace();
		}
	}

	public List<Compte> getList() {
		try {
			list = compteService.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public void setList(List<Compte> list) {
		this.list = list;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
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
