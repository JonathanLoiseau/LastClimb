package com.last_climb.climb.services;

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

public interface CheckOptionalGetObjectService {

	Utilisateur findAndCheckUserByUsernameAndPassword(String username, String password) throws CantFindUserException;

	Utilisateur findAndCheckUserById(Long id) throws CantFindUserException;

	Site findANdCheckSiteById(Long id) throws NoSiteException;

	Commentaire findANdCheckCommentaireById(Long id) throws NoCommentaryException;

	Topo findANdCheckTopoById(Long id) throws TopoNotFoundException;

	Secteur findAndCheckSecteurById(Long id) throws SecteurNotFoundException;
	
	Voie findAndCheckVoieById(Long id) throws CantFindVoieException ;
	
	Site findANdCheckSiteByName(String name ) throws SiteAlreadyExistException ;

}
