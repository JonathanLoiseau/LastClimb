package com.last_climb.climb.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.last_climb.climb.model.entity.Commentaire;
import com.last_climb.climb.model.form.CommentForm;

@Service
public class CommentFormToCommentImpl implements CommentFormToComment {

	@Override
	public Commentaire createCommentFromCommentForm(CommentForm commentForm) {

		Commentaire com = new Commentaire();
		com.setCommentaire(commentForm.getCommentaire());
		com.setUserName(commentForm.getUserName());
		com.setDate(LocalDateTime.now());

		return com;
	}

}
