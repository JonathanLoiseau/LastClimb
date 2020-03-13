package com.last_climb.climb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.last_climb.climb.model.UtilisateurPrincipal;
import com.last_climb.climb.model.entity.Utilisateur;
import com.last_climb.climb.model.exception.CantFindUserException;
import com.last_climb.climb.repo.UserRepo;

@Service
public class PrincipalToUserServiceImpl<T> implements PrincipalToUserService {

	@Autowired
	private UserRepo uRep;
	@Autowired
	private CheckOptionalGetObjectService checkOptional;

	@Override
	public Utilisateur principalToUser() {
		UtilisateurPrincipal up = (UtilisateurPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		Utilisateur user = up.getUser();
		return user;
	}

	@Override
	public Utilisateur principalToDbUser() throws CantFindUserException {
		UtilisateurPrincipal up = (UtilisateurPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		Utilisateur user = up.getUser();
		Utilisateur newUser = checkOptional.findAndCheckUserByUsernameAndPassword(user.getUsername(),
				user.getPassword());
		return newUser;

	}
}
