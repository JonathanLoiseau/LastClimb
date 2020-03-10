package com.last_climb.climb.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.last_climb.climb.model.InvalidFormException;
import com.last_climb.climb.model.Role;
import com.last_climb.climb.model.entity.Utilisateur;
import com.last_climb.climb.model.form.UserForm;
import com.last_climb.climb.repo.UserRepo;

@Service
public class UserFormToUserImpl implements UserFormToUserService {

	@Autowired
	private PasswordEncoder pass;

	@Autowired
	private UserRepo utilisateurRepository;

	@Override
	public void userCreation(UserForm uform) throws InvalidFormException {

		if (Objects.equals(uform.getMail(), uform.getMailConfirm())
				&& Objects.equals(uform.getPassword(), uform.getPasswordConfirm())) {

			Utilisateur user = new Utilisateur();
			user.setName(uform.getName());
			user.setUsername(uform.getUsername());
			user.setFirstname(uform.getFirstname());
			user.setBirthDate(uform.getBirthDate());
			user.setSex(uform.getSex());
			user.setBirthPlace(uform.getBirthPlace());
			user.setMail(uform.getMail());
			user.setRole(Role.ROLE_USER);
			user.setPassword(pass.encode(uform.getPassword()));
			utilisateurRepository.save(user);
		} else {
			throw new InvalidFormException();
		}

	}

}
