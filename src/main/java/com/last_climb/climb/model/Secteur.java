package com.last_climb.climb.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Secteur {

	public Secteur() {

	}

	public Secteur(String name, long id, Site site) {
		super();
		this.name = name;
		this.id = id;
		this.site = site;
	}

	private String name;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "Site_id", nullable = false)
	private Site site;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	@Override
	public String toString() {
		return "Secteur [name=" + name + ", id=" + id + ", site=" + site + "]";
	}

}
