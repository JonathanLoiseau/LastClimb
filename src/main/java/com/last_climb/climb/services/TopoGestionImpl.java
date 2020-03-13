package com.last_climb.climb.services;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.last_climb.climb.model.EtatTopo;
import com.last_climb.climb.model.entity.Topo;
import com.last_climb.climb.model.exception.TopoNotFoundException;
import com.last_climb.climb.repo.TopoRepository;

@Service
public class TopoGestionImpl implements TopoGestionService {

	@Autowired
	CheckOptionalGetObjectService chekAndGetTopo;
	@Autowired
	TopoRepository topoRepository;

	private static final Logger logger = LoggerFactory.getLogger(TopoGestionImpl.class);

	@Override
	public void share(Long id) {

		try {
			Topo dbTopo = chekAndGetTopo.findANdCheckTopoById(id);
			dbTopo.setEtat(EtatTopo.INDISPONIBLE);
			topoRepository.save(dbTopo);
		} catch (TopoNotFoundException e) {
			logger.error("TopoNotFound", e);
		}
	}

	@Transactional
	@Override
	public void makeAvailable(Long id) {
		try {
			Topo dbTopo = chekAndGetTopo.findANdCheckTopoById(id);
			dbTopo.setEtat(EtatTopo.DISPONIBLE);
			dbTopo.setBookerMail("");
			topoRepository.save(dbTopo);
		} catch (TopoNotFoundException e) {
			logger.error("TopoNotFound", e);
		}
	}

}
