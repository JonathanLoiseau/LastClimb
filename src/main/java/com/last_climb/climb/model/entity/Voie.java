package com.last_climb.climb.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Voie {

	public Voie(int id, int height, String cotation, int nbPoint, String name, Secteur secteur) {
		super();
		this.id = id;
		this.height = height;
		this.cotation = cotation;
		this.nbPoint = nbPoint;
		this.name = name;
		this.secteur = secteur;
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
}
