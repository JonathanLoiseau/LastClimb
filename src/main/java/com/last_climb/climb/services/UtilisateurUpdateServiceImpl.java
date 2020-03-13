package com.last_climb.climb.services;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.last_climb.climb.model.entity.Utilisateur;
import com.last_climb.climb.model.exception.CantFindUserException;
import com.last_climb.climb.model.exception.InvalidMailException;
import com.last_climb.climb.model.exception.InvalidPasswordExeption;
import com.last_climb.climb.model.form.UserForm;
import com.last_climb.climb.repo.UserRepo;

@Service
public class UtilisateurUpdateServiceImpl implements UserUpdateService {

	@Autowired
	private UserRepo uRep;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private CheckOptionalGetObjectService checkAndGet;

	private static final Logger logger = LoggerFactory.getLogger(UtilisateurUpdateServiceImpl.class);

	@Override
	public void updatePassword(Utilisateur user, UserForm userform) throws InvalidPasswordExeption {
		if (passwordEncoder.matches(userform.getPassword(), user.getPassword())) {
			String pass = user.getPassword();
			String uName = user.getUsername();
			Utilisateur utilisateurToUpdate;
			try {
				utilisateurToUpdate = checkAndGet.findAndCheckUserByUsernameAndPassword(uName, pass);
				String newPass = passwordEncoder.encode(userform.getNewPassword());
				utilisateurToUpdate.setPassword(newPass);
				uRep.save(utilisateurToUpdate);
			} catch (CantFindUserException e) {
				logger.error("cantFindUser", e);
			}

		} else {
			throw new InvalidPasswordExeption();
		}
	}

	@Override
	public void updateMail(Utilisateur user, UserForm userform) throws InvalidMailException {
		if (Objects.equals(user.getMail(), userform.getMail())) {
			String pass = user.getPassword();
			String uName = user.getUsername();

			try {
				Utilisateur utilisateurToUpdate = checkAndGet.findAndCheckUserByUsernameAndPassword(uName, pass);
				String newMail = userform.getNewMail();
				utilisateurToUpdate.setMail(newMail);
				uRep.save(utilisateurToUpdate);
			} catch (CantFindUserException e) {
				logger.error("cantFindUser", e);
			}

		} else {
			throw new InvalidMailException();
		}
	}

}
