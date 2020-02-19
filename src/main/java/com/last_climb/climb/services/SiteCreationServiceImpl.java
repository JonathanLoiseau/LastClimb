package com.last_climb.climb.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.last_climb.climb.model.IdContainer;
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

	private static final Logger logger = LoggerFactory.getLogger(SiteCreationServiceImpl.class);

	@Autowired
	private SecteurRepository secRep;

	@Autowired
	private SiteRepository sitRep;

	@Autowired
	private VoieRepository vRep;

	@Autowired
	private ExtractIdService extractor;

	@Transactional
	@Override
	public IdContainer create(SiteForm sf, CreationVoieForm cf, VoiesForm vf) {

		Secteur secteur = new Secteur();
		Site site = new Site();
		Voie voie = new Voie(vf);

		voie.setSecteur(secteur);
		secteur.setName(cf.getName());
		secteur.addVoie(voie);
		site.setName(sf.getName());
		site.addSecteur(secteur);
		secteur.setSite(site);

		if (sf.getId() == null && cf.getId() == null) {
			sitRep.save(site);
			secteur.setSite(site);
			secRep.save(secteur);
			voie.setSecteur(secteur);
			vRep.save(voie);
			logger.debug("y'a rien");
//			System.out.println("y'a rien");
			return extractor.extractId(site, secteur, voie);

		} else if (sf.getId() != null && cf.getId() == null) {
			Optional<Site> testSite = sitRep.findById(sf.getId());
			Site sitepresent = testSite.get();
			sitRep.save(sitepresent);
			secteur.setSite(sitepresent);
			secRep.save(secteur);
			voie.setSecteur(secteur);
			vRep.save(voie);
			logger.debug("seulement site");
//			System.out.println("seulement site présent");
			return extractor.extractId(sitepresent, secteur, voie);

		}

		else {
			logger.debug("test optional");
//			System.out.println("test optional");
			Optional<Site> testSite = sitRep.findById(sf.getId());
			Optional<Secteur> testSect = secRep.findById(cf.getId());
			Site sitepresent = testSite.get();
			Secteur secteurpresent = testSect.get();
			sitRep.save(sitepresent);
			secteurpresent.setSite(sitepresent);
			secRep.save(secteurpresent);
			voie.setSecteur(secteurpresent);
			vRep.save(voie);
			logger.debug("secteur et site présent");
//			System.out.println("secteur et site présent");
			return extractor.extractId(sitepresent, secteurpresent, voie);

		}
	}

}
