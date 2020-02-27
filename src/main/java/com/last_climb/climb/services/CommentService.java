package com.last_climb.climb.services;

import com.last_climb.climb.model.entity.Site;
import com.last_climb.climb.model.form.CommentForm;

public interface CommentService {

	void comment(Site s, CommentForm cf);
}
