package com.last_climb.climb.model.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

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

	@Lob
	private String description;

	private String lieux;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;

	public Topo(String name, Long iD, EtatTopo etat, Utilisateur user, String description, String lieux) {
		super();
		this.name = name;
		this.iD = iD;
		this.etat = etat;
		this.user = user;
		this.description = description;
		this.lieux = lieux;
		this.date = LocalDate.now();
	}

	public Topo() {
		this.etat = EtatTopo.DISPONIBLE;
		this.date = LocalDate.now();
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

	public Long getiD() {
		return iD;
	}

	public void setiD(Long iD) {
		this.iD = iD;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLieux() {
		return lieux;
	}

	public void setLieux(String lieux) {
		this.lieux = lieux;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
