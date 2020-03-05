package com.last_climb.climb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.last_climb.climb.model.UtilisateurPrincipal;
import com.last_climb.climb.model.entity.Utilisateur;
import com.last_climb.climb.repo.UserRepo;

@Service
public class PrincipalToUserServiceImpl implements PrincipalToUserService {

	@Autowired
	private UserRepo uRep;

	@Override
	public Utilisateur principalToUser() {
		UtilisateurPrincipal up = (UtilisateurPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		Utilisateur user = up.getUser();
		return user;
	}

	@Override
	public Utilisateur principalToDbUser() {
		UtilisateurPrincipal up = (UtilisateurPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		Utilisateur user = up.getUser();
		Optional<Utilisateur> presentUser = uRep.findById(user.getId());
		if (presentUser.isPresent()) {
			Utilisateur userFinal = presentUser.get();
			return userFinal;
		} else {
			// todo renvoie exeption
			return null;
		}

	}

}
