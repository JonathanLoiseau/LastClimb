package com.last_climb.climb.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.last_climb.climb.model.entity.Site;

public interface SiteRepository extends CrudRepository<Site, Long> {

	Optional<Site> findByName(String name);

}
