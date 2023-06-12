package com.bigcorp.booking.bean.subpackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Child extends Parent {

	private String nom;

	@Autowired
	@Qualifier("monJouetElectrique")
	private Toy toy;
	
	public Child(Toy toy) {
		System.out.println("Constructeur appelé");
		this.toy = toy;
	}
	
	public Child() {
		super();
	}

	public Child(String nom) {
		this.nom = nom;
	}

	public Toy getToy() {
		return toy;
	}
	
	public void setToy(Toy toy) {
		this.toy = toy;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void afficheSalut() {
		System.out.println(this + " affiche salut ! ");
	}

}
