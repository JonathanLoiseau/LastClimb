package com.last_climb.climb.model.form;

public class FindSiteForm {

	private String location;
	private int nbSecteur;
	private String cotation;

	public FindSiteForm() {

	}

	public FindSiteForm(String location, int nbSecteur, String cotation) {
		super();
		this.location = location;
		this.nbSecteur = nbSecteur;
		this.cotation = cotation;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getNbSecteur() {
		return nbSecteur;
	}

	public void setNbSecteur(int nbSecteur) {
		this.nbSecteur = nbSecteur;
	}

	public String getCotation() {
		return cotation;
	}

	public void setCotation(String cotation) {
		this.cotation = cotation;
	}

}
