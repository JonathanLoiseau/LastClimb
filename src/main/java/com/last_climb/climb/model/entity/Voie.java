package com.last_climb.climb.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.last_climb.climb.model.form.VoiesForm;

@Entity
public class Voie {

	public Voie() {
	}

	public Voie(int id, int height, String cotation, int nbPoint, String name, Secteur secteur) {
		super();
		this.id = id;
		this.height = height;
		this.cotation = cotation;
		this.nbPoint = nbPoint;
		this.name = name;
		this.secteur = secteur;
	}

	public Voie(VoiesForm vf) {
		this.height = vf.getHeight();
		this.cotation = vf.getCotation();
		this.nbPoint = vf.getNbPoint();
		this.name = vf.getName();

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int height;

	private String cotation;

	private int nbPoint;

	private String name;

	@ManyToOne
	@JoinColumn(name = "secteur_id", nullable = false)
	private Secteur secteur;

	@Override
	public String toString() {
		return "Voie [id=" + id + ", height=" + height + ", cotation=" + cotation + ", nbPoint=" + nbPoint + ", name="
				+ name + ", secteur=" + secteur + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getCotation() {
		return cotation;
	}

	public void setCotation(String cotation) {
		this.cotation = cotation;
	}

	public int getNbPoint() {
		return nbPoint;
	}

	public void setNbPoint(int nbPoint) {
		this.nbPoint = nbPoint;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Secteur getSecteur() {
		return secteur;
	}

	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}
}
