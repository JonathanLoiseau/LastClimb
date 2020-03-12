package com.last_climb.climb.services;

import com.last_climb.climb.model.entity.Commentaire;
import com.last_climb.climb.model.form.CommentForm;

public interface CommentFormToComment {

	Commentaire createCommentFromCommentForm(CommentForm commentForm);
}
