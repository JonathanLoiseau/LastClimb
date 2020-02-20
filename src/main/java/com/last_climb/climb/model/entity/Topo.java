package com.last_climb.climb.model.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.last_climb.climb.model.EtatTopo;

@Entity
public class Topo {

	private String name;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iD;

	@Enumerated(EnumType.STRING)
	private EtatTopo etat;

	@ManyToOne
	@JoinColumn(name = "User_id", nullable = false)
	private Utilisateur user;

	public Topo() {
		this.etat = EtatTopo.DISPONIBLE;
	}

	public Topo(String name, Long iD, Utilisateur user) {
		super();
		this.name = name;
		this.iD = iD;
		this.etat = EtatTopo.DISPONIBLE;
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getID() {
		return iD;
	}

	public void setID(Long iD) {
		this.iD = iD;
	}

	public EtatTopo getEtat() {
		return etat;
	}

	public void setEtat(EtatTopo etat) {
		this.etat = etat;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

}
