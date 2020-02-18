package com.last_climb.climb.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.last_climb.climb.model.entity.Secteur;
import com.last_climb.climb.model.entity.Site;
import com.last_climb.climb.model.entity.Voie;
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

	@Transactional
	@Override
	public void create(SiteForm sf, CreationVoieForm cf, VoiesForm vf) {

		Secteur secteur = new Secteur();
		Site site = new Site();
		Voie voie = new Voie(vf);

		voie.setSecteur(secteur);
		secteur.setName(cf.getName());
		secteur.addVoie(voie);
		site.setName(sf.getName());
		site.addSecteur(secteur);
		secteur.setSite(site);

		Optional<Site> testSite = sitRep.findByName(site.getName());
		Optional<Secteur> testSect = secRep.findByName(secteur.getName());

		if (testSite.isPresent() && testSect.isPresent()) {
			Site sitepresent = testSite.get();
			Secteur secteurpresent = testSect.get();
			sitRep.save(sitepresent);
			secteurpresent.setSite(sitepresent);
			secRep.save(secteurpresent);
			voie.setSecteur(secteurpresent);
			vRep.save(voie);

		} else if (testSite.isPresent() && !testSect.isPresent()) {
			Site sitepresent = testSite.get();
			sitRep.save(sitepresent);
			secteur.setSite(sitepresent);
			secRep.save(secteur);
			voie.setSecteur(secteur);
			vRep.save(voie);

		}

		else {
			sitRep.save(site);
			secteur.setSite(site);
			secRep.save(secteur);
			voie.setSecteur(secteur);
			vRep.save(voie);
		}
	}
}
