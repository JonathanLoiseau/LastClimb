package com.last_climb.climb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.last_climb.climb.model.entity.Utilisateur;
import com.last_climb.climb.repo.UserRepo;

@Service
public class CheckOptionalImpl<T> implements CheckOptional<T> {

	@Autowired
	private UserRepo uRep;

	@Override
	public boolean check(Optional<T> opt) {
		return opt.isPresent();

	}

	@Override
	public boolean findAndCheck(String username, String password) {
		Optional<Utilisateur> newUser = uRep.findByUsernameAndPassword(username, password);
		return newUser.isPresent();
	}

}
