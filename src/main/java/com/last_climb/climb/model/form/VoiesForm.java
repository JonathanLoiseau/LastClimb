package com.last_climb.climb.model.form;

import com.last_climb.climb.model.entity.Secteur;

public class VoiesForm {
	private int height;

	private String cotation;

	private int nbPoint;

	private String name;

	private Long id;

	public VoiesForm() {
	}

	public VoiesForm(int height, String cotation, int nbPoint, String name, Secteur secteur) {
		super();
		this.height = height;
		this.cotation = cotation;
		this.nbPoint = nbPoint;
		this.name = name;

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

	@Override
	public String toString() {
		return "VoiesForm [height=" + height + ", cotation=" + cotation + ", nbPoint=" + nbPoint + ", name=" + name
				+ ", secteur=" + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
