package com.last_climb.climb.services;

import com.last_climb.climb.model.form.CreationVoieForm;
import com.last_climb.climb.model.form.SiteForm;
import com.last_climb.climb.model.form.VoiesForm;

public interface SiteCreationService {

	void create(SiteForm sf, CreationVoieForm cf, VoiesForm vf);

}
