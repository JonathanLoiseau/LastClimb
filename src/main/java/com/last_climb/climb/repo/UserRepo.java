package com.last_climb.climb.repo;

import org.springframework.data.repository.CrudRepository;

import com.last_climb.climb.model.Utilisateur;

public interface UserRepo extends CrudRepository<Utilisateur, Integer> {

}
