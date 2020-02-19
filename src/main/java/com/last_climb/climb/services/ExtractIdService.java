package com.last_climb.climb.services;

import com.last_climb.climb.model.IdContainer;
import com.last_climb.climb.model.entity.Secteur;
import com.last_climb.climb.model.entity.Site;
import com.last_climb.climb.model.entity.Voie;

public interface ExtractIdService {

	IdContainer extractId(Site site, Secteur secteur, Voie voie);

}
