package com.last_climb.climb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.last_climb.climb.model.entity.Commentaire;
import com.last_climb.climb.model.entity.Secteur;
import com.last_climb.climb.model.entity.Site;
import com.last_climb.climb.model.entity.Topo;
import com.last_climb.climb.model.entity.Utilisateur;
import com.last_climb.climb.model.entity.Voie;
import com.last_climb.climb.model.exception.CantFindUserException;
import com.last_climb.climb.model.exception.CantFindVoieException;
import com.last_climb.climb.model.exception.NoCommentaryException;
import com.last_climb.climb.model.exception.NoSiteException;
import com.last_climb.climb.model.exception.SecteurNotFoundException;
import com.last_climb.climb.model.exception.SiteAlreadyExistException;
import com.last_climb.climb.model.exception.TopoNotFoundException;
import com.last_climb.climb.repo.CommentaireRepository;
import com.last_climb.climb.repo.SecteurRepository;
import com.last_climb.climb.repo.SiteRepository;
import com.last_climb.climb.repo.TopoRepository;
import com.last_climb.climb.repo.UserRepo;
import com.last_climb.climb.repo.VoieRepository;

@Service
public class CheckOptionalGetObjectImpl implements CheckOptionalGetObjectService {

	@Autowired
	private UserRepo userRepository;
	@Autowired
	private SiteRepository siteRepository;
	@Autowired
	private CommentaireRepository commentaireRepository;
	@Autowired
	private TopoRepository topoRepository;
	@Autowired
	private SecteurRepository secteurRepository;
	@Autowired
	private VoieRepository voieRepository;

	@Override
	public Utilisateur findAndCheckUserByUsernameAndPassword(String username, String password)
			throws CantFindUserException {
		Optional<Utilisateur> newUser = userRepository.findByUsernameAndPassword(username, password);
		if (newUser.isPresent()) {
			Utilisateur user = newUser.get();
			return user;
		} else {
			throw new CantFindUserException();
		}
	}

	@Override
	public Utilisateur findAndCheckUserById(Long id) throws CantFindUserException {
		Optional<Utilisateur> newUser = userRepository.findById(id);
		if (newUser.isPresent()) {
			Utilisateur user = newUser.get();
			return user;
		} else {
			throw new CantFindUserException();
		}
	}

	@Override
	public Site findANdCheckSiteById(Long id) throws NoSiteException {
		Optional<Site> newSite = siteRepository.findById(id);
		if (newSite.isPresent()) {
			return newSite.get();
		} else {
			throw new NoSiteException();
		}
	}

	@Override
	public Commentaire findANdCheckCommentaireById(Long id) throws NoCommentaryException {
		Optional<Commentaire> newComm = commentaireRepository.findById(id);
		if (newComm.isPresent()) {
			Commentaire comm = newComm.get();
			return comm;
		} else {
			throw new NoCommentaryException();
		}
	}

	@Override
	public Topo findANdCheckTopoById(Long id) throws TopoNotFoundException {

		Optional<Topo> newTopo = topoRepository.findById(id);
		if (newTopo.isPresent()) {
			Topo topo = newTopo.get();
			return topo;
		} else {
			throw new TopoNotFoundException();
		}
	}

	@Override
	public Secteur findAndCheckSecteurById(Long id) throws SecteurNotFoundException {
		Optional<Secteur> newSecteur = secteurRepository.findById(id);
		if (newSecteur.isPresent()) {
			Secteur secteur = newSecteur.get();
			return secteur;
		} else {
			throw new SecteurNotFoundException();
		}
	}

	@Override
	public Voie findAndCheckVoieById(Long id) throws CantFindVoieException {
		Optional<Voie> newVoie = voieRepository.findById(id);
		if (newVoie.isPresent()) {
			Voie voie = newVoie.get();
			return voie;
		} else {
			throw new CantFindVoieException();
		}

	}

	@Override
	public Site findANdCheckSiteByName(String name) throws SiteAlreadyExistException {
		Optional<Site> newSite = siteRepository.findByName(name);
		if (newSite.isPresent()) {
			return newSite.get();
		} else {
			throw new SiteAlreadyExistException();
		
	}
	}
}
