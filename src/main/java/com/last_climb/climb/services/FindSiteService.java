package com.last_climb.climb.services;

import java.util.List;

import com.last_climb.climb.model.entity.Site;
import com.last_climb.climb.model.form.FindSiteForm;

public interface FindSiteService {

	List<Site> findSite(FindSiteForm fsf);

}
