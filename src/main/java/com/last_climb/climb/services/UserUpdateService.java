package com.last_climb.climb.services;

import com.last_climb.climb.model.UserForm;
import com.last_climb.climb.model.Utilisateur;

public interface UserUpdateService {

	void update(Utilisateur user, UserForm userform);

}
