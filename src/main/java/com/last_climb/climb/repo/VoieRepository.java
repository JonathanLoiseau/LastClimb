package com.last_climb.climb.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.last_climb.climb.model.entity.Voie;

public interface VoieRepository extends CrudRepository<Voie, Long> {

	Optional<Voie> findByName(String name);

	void save(Optional<Voie> testvoie);

}
