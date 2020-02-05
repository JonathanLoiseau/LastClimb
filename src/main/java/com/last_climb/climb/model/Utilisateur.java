package com.last_climb.climb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UTILISATEUR")
public class Utilisateur {

	private String firstname;

	private String name;

	private String username;

	private String password;

	private String birthPlace;

	private String sex;

	private String birthDate;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String mail;

//		private boolean log;

	public Utilisateur() {

	}

	public Utilisateur(String name, String firstname, String username, String password, String sex, String birthplace,
			String birthdate, String mail) {

		this.firstname = firstname;
		this.name = name;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.birthPlace = birthplace;
		this.birthDate = birthdate;
		this.mail = mail;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public synchronized String getBirthPlace() {
		return birthPlace;
	}

	public synchronized void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public synchronized String getSex() {
		return sex;
	}

	public synchronized void setSex(String sex) {
		this.sex = sex;
	}

	public synchronized String getBirthDate() {
		return birthDate;
	}

	public synchronized void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

//		public synchronized boolean isLog() {
//			return log;
//		}
	//
//		public synchronized void setLog(boolean log) {
//			this.log = log;
//		}

	public synchronized String getMail() {
		return mail;
	}

	public synchronized void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Utilisateur [firstname=" + firstname + ", name=" + name + ", username=" + username + ", password="
				+ password + "]";
	}

}
