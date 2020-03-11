package com.last_climb.climb.services;

import com.last_climb.climb.model.entity.Utilisateur;
import com.last_climb.climb.model.exception.CantFindUserException;

public interface PrincipalToUserService {

	Utilisateur principalToUser();

	Utilisateur principalToDbUser() throws CantFindUserException;
}
