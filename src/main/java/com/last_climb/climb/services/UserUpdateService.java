package com.last_climb.climb.services;

import com.last_climb.climb.model.entity.Utilisateur;
import com.last_climb.climb.model.exception.InvalidMailException;
import com.last_climb.climb.model.exception.InvalidPasswordExeption;
import com.last_climb.climb.model.form.UserForm;

public interface UserUpdateService {

	void updatePassword(Utilisateur user, UserForm userform) throws InvalidPasswordExeption;

	void updateMail(Utilisateur user, UserForm userform) throws InvalidMailException;

}
