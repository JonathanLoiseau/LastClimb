package com.last_climb.climb.services;

import com.last_climb.climb.model.IdContainer;
import com.last_climb.climb.model.exception.NoSiteException;
import com.last_climb.climb.model.exception.SecteurNotFoundException;
import com.last_climb.climb.model.form.CreationVoieForm;
import com.last_climb.climb.model.form.SiteForm;
import com.last_climb.climb.model.form.VoiesForm;

public interface SiteCreationService {

	IdContainer create(SiteForm sf, CreationVoieForm cf, VoiesForm vf) throws NoSiteException, SecteurNotFoundException;

}
