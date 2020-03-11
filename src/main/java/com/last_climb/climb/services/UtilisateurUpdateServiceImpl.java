package com.last_climb.climb.services;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.last_climb.climb.model.entity.Utilisateur;
import com.last_climb.climb.model.exception.InvalidMailException;
import com.last_climb.climb.model.exception.InvalidPasswordExeption;
import com.last_climb.climb.model.form.UserForm;
import com.last_climb.climb.repo.UserRepo;

@Service
public class UtilisateurUpdateServiceImpl implements UserUpdateService {

	@Autowired
	private UserRepo uRep;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public void updatePassword(Utilisateur user, UserForm userform) throws InvalidPasswordExeption {
//		String password = passwordEncoder.encode(userform.getPassword());

		if (passwordEncoder.matches(userform.getPassword(), user.getPassword())) {
			String pass = user.getPassword();
			String uName = user.getUsername();
			Optional<Utilisateur> newUser = uRep.findByUsernameAndPassword(uName, pass);
			String newPass = passwordEncoder.encode(userform.getNewPassword());
			Utilisateur uToUpdate = newUser.get();
			uToUpdate.setPassword(newPass);
			uRep.save(uToUpdate);
		} else {
			throw new InvalidPasswordExeption();
		}
	}

	@Override
	public void updateMail(Utilisateur user, UserForm userform) throws InvalidMailException {
		if (Objects.equals(user.getMail(), userform.getMail())) {
			String pass = user.getPassword();
			String uName = user.getUsername();
			Optional<Utilisateur> newUser = uRep.findByUsernameAndPassword(uName, pass);
			String newMail = userform.getNewMail();
			Utilisateur uToUpdate = newUser.get();
			uToUpdate.setMail(newMail);
			uRep.save(uToUpdate);
		} else {
			throw new InvalidMailException();
		}

	}

}
