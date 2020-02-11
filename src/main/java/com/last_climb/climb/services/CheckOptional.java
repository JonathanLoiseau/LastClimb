package com.last_climb.climb.services;

import java.util.Optional;

public interface CheckOptional<T> {
	boolean check(Optional<T> opt);

	boolean findAndCheck(String a, String b);

}
