package com.last_climb.climb.services;

import java.util.HashSet;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.last_climb.climb.model.IdContainer;
import com.last_climb.climb.model.entity.Secteur;
import com.last_climb.climb.model.entity.Site;
import com.last_climb.climb.model.entity.Voie;
import com.last_climb.climb.model.exception.NoSiteException;
import com.last_climb.climb.model.exception.SecteurNotFoundException;
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

	@Autowired
	private VoieFormToVoie voieFormToVoie;
	@Autowired
	private CheckOptionalGetObjectService checkAndGet;

	@Transactional
	@Override
	public IdContainer create(SiteForm sf, CreationVoieForm cf, VoiesForm vf)
			throws NoSiteException, SecteurNotFoundException {

		Secteur secteur = new Secteur();
		Site site = new Site();
		Voie voie = voieFormToVoie.createVoie(vf, secteur);

		secteur.setName(cf.getName());
		secteur.setListvoies(new HashSet<Voie>());
		secteur.addVoie(voie);

		site.setName(sf.getName());
		site.setLocalisation(sf.getLocalisation());
		site.setSiteimg(sf.getSiteimg());
		site.setListSecteur(new HashSet<Secteur>());
		site.addSecteur(secteur);

		secteur.setSite(site);

		if (sf.getId() == null && cf.getId() == null) {
			sitRep.save(site);
			secteur.setSite(site);
			secRep.save(secteur);
			voie.setSecteur(secteur);
			vRep.save(voie);
			logger.debug("y'a rien");
			return extractor.extractId(site, secteur, voie);

		} else if (sf.getId() != null && cf.getId() == null) {

			Site sitepresent = checkAndGet.findANdCheckSiteById(sf.getId());
			sitepresent.setNbSect(sitepresent.getNbSect() + 1);
			sitRep.save(sitepresent);
			secteur.setSite(sitepresent);
			secRep.save(secteur);
			voie.setSecteur(secteur);
			vRep.save(voie);
			logger.debug("seulement site");
			return extractor.extractId(sitepresent, secteur, voie);
		}

		else {
			logger.debug("test optional");
			Site sitepresent = checkAndGet.findANdCheckSiteById(sf.getId());
			Secteur secteurpresent = checkAndGet.findAndCheckSecteurById(cf.getId());
			sitRep.save(sitepresent);
			secteurpresent.setSite(sitepresent);
			secRep.save(secteurpresent);
			voie.setSecteur(secteurpresent);
			vRep.save(voie);
			logger.debug("secteur et site présent");
			return extractor.extractId(sitepresent, secteurpresent, voie);
		}
	}
}
