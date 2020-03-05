package com.last_climb.climb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.last_climb.climb.model.entity.Utilisateur;
import com.last_climb.climb.model.form.UserForm;
import com.last_climb.climb.repo.UserRepo;

@Service
public class UtilisateurUpdateServiceImpl implements UserUpdateService {

	@Autowired
	private UserRepo uRep;

	@Override
	public void updatePassword(Utilisateur user, UserForm userform) {

		String pass = user.getPassword();
		String uName = user.getUsername();
		Optional<Utilisateur> newUser = uRep.findByUsernameAndPassword(uName, pass);
		String newPass = userform.getNewPassword();
		Utilisateur uToUpdate = newUser.get();
		uToUpdate.setPassword(newPass);
		uRep.save(uToUpdate);
	}

	@Override
	public void updateMail(Utilisateur user, UserForm userform) {
		String pass = user.getPassword();
		String uName = user.getUsername();
		Optional<Utilisateur> newUser = uRep.findByUsernameAndPassword(uName, pass);
		String newMail = userform.getNewMail();
		Utilisateur uToUpdate = newUser.get();
		uToUpdate.setMail(newMail);
		uRep.save(uToUpdate);

	}

}
