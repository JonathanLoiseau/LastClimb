package com.last_climb.climb.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.last_climb.climb.model.entity.Secteur;

public interface SecteurRepository extends CrudRepository<Secteur, Long> {

	Optional<Secteur> findByName(String name);

}
