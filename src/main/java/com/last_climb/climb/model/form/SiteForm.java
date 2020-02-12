package com.last_climb.climb.model.form;

public class SiteForm {
	private int nbSecteur;
	private String name;

	public SiteForm() {
	}

	public SiteForm(int nbSecteur, String name) {
		super();
		this.nbSecteur = nbSecteur;
		this.name = name;
	}

	public int getNbSecteur() {
		return nbSecteur;
	}

	public void setNbSecteur(int nbSecteur) {
		this.nbSecteur = nbSecteur;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SiteForm [nbSecteur=" + nbSecteur + ", name=" + name + "]";
	}

}
