package com.last_climb.climb.services;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.last_climb.climb.model.entity.Topo;
import com.last_climb.climb.model.entity.Utilisateur;
import com.last_climb.climb.model.exception.CantFindUserException;
import com.last_climb.climb.repo.TopoRepository;
import com.last_climb.climb.repo.UserRepo;

@Service
@Transactional
public class TopoCreatorImpl implements TopoCreator {
	@Autowired
	UserRepo uRep;
	@Autowired
	TopoRepository tRep;
	@Autowired
	CheckOptionalGetObjectService checkandGetUser;

	private final static Logger logger = LoggerFactory.getLogger(TopoCreatorImpl.class);

	@Override
	public void topoCreator(Topo topo, Utilisateur user) {

		try {
			Utilisateur topoUser = checkandGetUser.findAndCheckUserById(user.getId());
			topo.setUser(topoUser);
			tRep.save(topo);

		} catch (CantFindUserException e) {
			logger.error("cantFindUser", e);
		}
	}

}
