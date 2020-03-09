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
public class TopoBookingImpl implements TopoBookingService {

	@Autowired
	private TopoRepository topoRepository;
	@Autowired
	private UserRepo userRepo;

	@Transactional
	@Override
	public void bookTopo(Long Topoid, Long userId) {
		Optional<Topo> optTopo = topoRepository.findById(Topoid);
		Optional<Utilisateur> optUser = userRepo.findById(userId);
		if (optTopo.isPresent() && optUser.isPresent()) {
			Topo topo = optTopo.get();
			Utilisateur user = optUser.get();
			topo.setBooked(true);
			topo.setBookerMail(user.getMail());
			topoRepository.save(topo);
		}

	}

}
