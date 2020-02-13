package com.last_climb.climb.model.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Secteur {

	@ManyToOne
	@JoinColumn(name = "Site_id", nullable = false)
	private Site site;

	@OneToMany(mappedBy = "secteur")
	private Set<Voie> listvoies;

	private String name;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public Secteur() {

	}

	public Secteur(String name, long id, Site site) {
		super();
		this.name = name;
		this.id = id;
		this.site = site;
	}

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

	public Set<Voie> getListvoies() {
		return listvoies;
	}

	public void setListvoies(Set<Voie> listvoies) {
		this.listvoies = listvoies;
	}

	@Override
	public String toString() {
		return "Secteur [site=" + site + ", listvoies=" + listvoies + ", name=" + name + ", id=" + id + "]";
	}

}
