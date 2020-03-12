package com.last_climb.climb.services;

import org.springframework.stereotype.Service;

import com.last_climb.climb.model.entity.Secteur;
import com.last_climb.climb.model.entity.Voie;
import com.last_climb.climb.model.form.VoiesForm;

@Service
public class VoieFormToVoieImpl implements VoieFormToVoie {

	@Override
	public Voie createVoie(VoiesForm voieForm, Secteur secteur) {

		Voie voie = new Voie();

		voie.setSecteur(secteur);
		voie.setCotation(voieForm.getCotation());
		voie.setHeight(voieForm.getHeight());
		voie.setNbPoint(voieForm.getNbPoint());
		voie.setName(voieForm.getName());
		return voie;
	}

}
