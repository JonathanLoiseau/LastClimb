package com.last_climb.climb.services;

import org.springframework.stereotype.Service;

import com.last_climb.climb.model.IdContainer;
import com.last_climb.climb.model.entity.Secteur;
import com.last_climb.climb.model.entity.Site;
import com.last_climb.climb.model.entity.Voie;

@Service
public class ExtractIdImpl implements ExtractIdService {

	@Override
	public IdContainer extractId(Site site, Secteur secteur, Voie voie) {
		IdContainer c = new IdContainer();

		c.setSiteId(site.getId());
		c.setSecteurId(secteur.getId());
		c.setVoieId(voie.getId());

		return c;
		// TODO Auto-generated method stub

	}

}
