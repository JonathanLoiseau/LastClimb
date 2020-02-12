package com.last_climb.climb.services;

import com.last_climb.climb.model.entity.Utilisateur;
import com.last_climb.climb.model.form.UserForm;

public interface UserUpdateService {

	void update(Utilisateur user, UserForm userform);

}
