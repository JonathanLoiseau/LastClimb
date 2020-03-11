package com.last_climb.climb.services;

import com.last_climb.climb.model.entity.Site;
import com.last_climb.climb.model.entity.Utilisateur;
import com.last_climb.climb.model.exception.CantFindUserException;
import com.last_climb.climb.model.exception.NoSiteException;

public interface CheckOptionalGetObjectService<T> {
	Utilisateur findAndCheckUserByUsernameAndPassword(String username, String password) throws CantFindUserException;

	Utilisateur findAndCheckUserById(Long id) throws CantFindUserException;

	Site findANdCheckSiteById(Long id) throws NoSiteException;

}
