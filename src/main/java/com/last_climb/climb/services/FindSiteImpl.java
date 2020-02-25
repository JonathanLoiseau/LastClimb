package com.last_climb.climb.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.last_climb.climb.model.entity.Site;
import com.last_climb.climb.model.form.FindSiteForm;
import com.last_climb.climb.repo.SiteRepository;

@Service
public class FindSiteImpl implements FindSiteService {

	@Autowired
	private SiteRepository sRep;

	@Override
	@Transactional
	public List<Site> findSite(FindSiteForm fsf) {
		int nbSecteur = fsf.getNbSecteur();
		String cotation = fsf.getCotation();
		String location = fsf.getLocation();

		ArrayList<Site> siteList = sRep.findDistinctByListSecteur_Listvoies_CotationAndNbSectAndLocalisation(cotation,
				nbSecteur, location);

		return siteList;
	}

}
