package com.last_climb.climb.model.form;

import java.util.ArrayList;

public class CreationVoieForm {

	public int nbvoie;
	public String name;
	public ArrayList<VoiesForm> voieform;

	public int getNbvoie() {
		return nbvoie;
	}

	public void setNbvoie(int nbvoie) {
		this.nbvoie = nbvoie;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CreationVoieForm [nbvoie=" + nbvoie + ", name=" + name + "]";
	}

}
