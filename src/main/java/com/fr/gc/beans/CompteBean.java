package com.fr.gc.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.fr.gc.entities.Compte;
import com.fr.gc.services.CompteService;
import com.fr.gc.services.impl.CompteServiceImpl;

@ManagedBean
@ViewScoped
public class CompteBean implements Serializable {
    
	private Compte compte = new Compte();
	private CompteService compteService = new CompteServiceImpl();
	private List<Compte> list = new ArrayList<>();

	public List<Compte> getList() {
	    try {
			list = compteService.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return list ;
	}

	public void setList(List<Compte> list) {
		this.list = list;
	}

}
