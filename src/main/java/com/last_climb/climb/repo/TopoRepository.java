package com.last_climb.climb.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.last_climb.climb.model.entity.Topo;

public interface TopoRepository extends CrudRepository<Topo, Long> {

	List<Topo> findAllByLieux(String string);

	List<Topo> findByLieux(String lieux);

}
