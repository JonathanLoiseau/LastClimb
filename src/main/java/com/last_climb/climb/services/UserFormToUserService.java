package com.last_climb.climb.services;

import com.last_climb.climb.model.InvalidFormException;
import com.last_climb.climb.model.form.UserForm;

public interface UserFormToUserService {

	void userCreation(UserForm uform) throws InvalidFormException;
}
