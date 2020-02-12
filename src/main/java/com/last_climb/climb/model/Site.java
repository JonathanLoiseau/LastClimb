package com.last_climb.climb.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Site {

	private String name;
	@OneToMany(mappedBy = "site")
	private Set<Secteur> listSecteur;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public Site() {

	}

	public Site(String name, Set<Secteur> listSecteur, long id) {
		super();
		this.name = name;
		this.listSecteur = listSecteur;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Secteur> getListSecteur() {
		return listSecteur;
	}

	public void setListSecteur(Set<Secteur> listSecteur) {
		this.listSecteur = listSecteur;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Site [name=" + name + ", listSecteur=" + listSecteur + ", id=" + id + "]";
	}

}
