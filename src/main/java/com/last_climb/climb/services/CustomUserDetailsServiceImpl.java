package com.last_climb.climb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.last_climb.climb.model.UtilisateurPrincipal;
import com.last_climb.climb.model.entity.Utilisateur;
import com.last_climb.climb.repo.UserRepo;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepo userRep;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Utilisateur> user = userRep.findByUsername(username);

		if (user.isPresent()) {
			return new UtilisateurPrincipal(user.get());
		} else {
			throw new UsernameNotFoundException(("Username  not found"));
		}

	}

}
