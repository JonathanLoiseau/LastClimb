package com.last_climb.climb.services;

import com.last_climb.climb.model.entity.Utilisateur;

public interface PrincipalToUserService {

	Utilisateur principalToUser();

	Utilisateur principalToDbUser();
}
