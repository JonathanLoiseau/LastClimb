package com.last_climb.climb.model.form;

import java.time.LocalDate;

import com.last_climb.climb.model.Sex;
import com.last_climb.climb.model.entity.Utilisateur;

public class UserForm {

	public UserForm() {
	}

	public UserForm(String firstname, String name, String username, String password, String newPassword, String mail,
			String newMail, String birthPlace, LocalDate birthDate, Sex sex) {
		super();
		this.firstname = firstname;
		this.name = name;
		this.username = username;
		this.password = password;
		this.newPassword = newPassword;
		this.mail = mail;
		this.newMail = newMail;
		this.birthPlace = birthPlace;
		this.birthDate = birthDate;
		this.sex = sex;
	}

	public UserForm(Utilisateur user) {
		this.firstname = user.getFirstname();
		this.name = user.getName();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.mail = user.getMail();
		this.birthPlace = user.getBirthPlace();
		this.birthDate = user.getBirthDate();
		this.sex = user.getSex();
	}

	private String firstname;

	private String name;

	private String username;

	private String password;

	private String newPassword;

	private String mail;

	private String newMail;

	private String birthPlace;

	private LocalDate birthDate;

	private Sex sex;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
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

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNewMail() {
		return newMail;
	}

	public void setNewMail(String newMail) {
		this.newMail = newMail;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "UserForm [firstname=" + firstname + ", name=" + name + ", username=" + username + ", password="
				+ password + ", newPassword=" + newPassword + ", mail=" + mail + ", newMail=" + newMail
				+ ", birthPlace=" + birthPlace + ", birthDate=" + birthDate + ", sex=" + sex + "]";
	}

}
