package com.last_climb.climb.services;

import com.last_climb.climb.model.entity.Site;
import com.last_climb.climb.model.exception.NoCommentaryException;
import com.last_climb.climb.model.form.CommentForm;

public interface CommentService {

	void comment(Site s, CommentForm cf);

	void delete(Long id) throws NoCommentaryException;

	void edit(Long id, String commentaire) throws NoCommentaryException;
}
