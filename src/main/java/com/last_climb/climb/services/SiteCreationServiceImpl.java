package com.last_climb.climb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.last_climb.climb.model.form.CreationVoieForm;
import com.last_climb.climb.model.form.SiteForm;
import com.last_climb.climb.model.form.VoiesForm;
import com.last_climb.climb.repo.SecteurRepository;
import com.last_climb.climb.repo.SiteRepository;
import com.last_climb.climb.repo.VoieRepository;

@Service
public class SiteCreationServiceImpl implements SiteCreationService {

	@Autowired
	SecteurRepository secRep;

	@Autowired
	SiteRepository sitRep;

	@Autowired
	VoieRepository vRep;

	@Override
	public void create(SiteForm sf, CreationVoieForm cf, VoiesForm vf) {

	}

}
