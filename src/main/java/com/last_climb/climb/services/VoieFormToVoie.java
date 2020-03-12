package com.last_climb.climb.services;

import com.last_climb.climb.model.entity.Secteur;
import com.last_climb.climb.model.entity.Voie;
import com.last_climb.climb.model.form.VoiesForm;

public interface VoieFormToVoie {
	Voie createVoie(VoiesForm voieForm, Secteur secteur);
}
