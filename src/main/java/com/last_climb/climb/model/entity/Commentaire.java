package com.last_climb.climb.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

import com.last_climb.climb.model.form.CommentForm;

@Entity
public class Commentaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Lob
	@Type(type = "text")
	private String commentaire;

	@ManyToOne
	@JoinColumn(name = "site_id", nullable = false)
	private Site site;

	private String userName;

	private LocalDateTime date;

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Commentaire(Long id, String commentaire, String userName, Site site) {
		super();
		this.id = id;
		this.commentaire = commentaire;
		this.userName = userName;
		this.site = site;
		this.date = LocalDateTime.now();
	}

	public Commentaire(CommentForm cf) {
		this.commentaire = cf.getCommentaire();
		this.userName = cf.getUserName();
		this.date = LocalDateTime.now();
	}

	public Commentaire() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}
}
