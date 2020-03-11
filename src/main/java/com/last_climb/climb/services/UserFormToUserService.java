package com.last_climb.climb.services;

import com.last_climb.climb.model.exception.InvalidFormException;
import com.last_climb.climb.model.form.UserForm;

public interface UserFormToUserService {

	void userCreation(UserForm uform) throws InvalidFormException;
}
