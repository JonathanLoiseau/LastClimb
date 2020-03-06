package com.last_climb.climb.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.last_climb.climb.model.EtatTopo;
import com.last_climb.climb.model.entity.Topo;
import com.last_climb.climb.repo.TopoRepository;

@Service
public class TopoGestionImpl implements TopoGestionService {

	@Autowired
	TopoRepository tRep;

	@Transactional
	@Override
	public void share(Long id) {

		Optional<Topo> topo = tRep.findById(id);
		if (topo.isPresent()) {
			Topo dbTopo = topo.get();
			dbTopo.setEtat(EtatTopo.INDISPONIBLE);
			tRep.save(dbTopo);
		} else {
			// todo error
		}

	}

	@Transactional
	@Override
	public void makeAvailable(Long id) {
		Optional<Topo> topo = tRep.findById(id);
		if (topo.isPresent()) {
			Topo dbTopo = topo.get();
			dbTopo.setEtat(EtatTopo.DISPONIBLE);
			tRep.save(dbTopo);
		} else {
			// todo error
		}

	}

}
