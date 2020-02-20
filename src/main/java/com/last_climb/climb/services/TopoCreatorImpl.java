package com.last_climb.climb.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.last_climb.climb.model.entity.Topo;
import com.last_climb.climb.model.entity.Utilisateur;
import com.last_climb.climb.repo.TopoRepository;
import com.last_climb.climb.repo.UserRepo;

@Service
@Transactional
public class TopoCreatorImpl implements TopoCreator {
	@Autowired
	UserRepo uRep;
	@Autowired
	TopoRepository tRep;

	@Override
	public void topoCreator(Topo topo, Utilisateur user) {
		Optional<Utilisateur> optTopoUser = uRep.findById(user.getId());
		Utilisateur topoUser = optTopoUser.get();
		topo.setUser(topoUser);
		tRep.save(topo);

	}

}
