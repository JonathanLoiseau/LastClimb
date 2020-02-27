package com.last_climb.climb.model.form;

public class CommentForm {
	private String userName;
	private String commentaire;

	public CommentForm(String userName, String commentaire) {
		super();
		this.userName = userName;
		this.commentaire = commentaire;

	}

	public CommentForm(String username) {
		this.userName = username;
	}

	public CommentForm() {

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	@Override
	public String toString() {
		return "CommentForm [userName=" + userName + ", commentaire=" + commentaire + " ]";
	}
}
