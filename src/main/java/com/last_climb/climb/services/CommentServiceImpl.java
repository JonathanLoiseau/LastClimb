package com.last_climb.climb.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.last_climb.climb.model.entity.Commentaire;
import com.last_climb.climb.model.entity.Site;
import com.last_climb.climb.model.exception.NoCommentaryException;
import com.last_climb.climb.model.exception.NoSiteException;
import com.last_climb.climb.model.form.CommentForm;
import com.last_climb.climb.repo.CommentaireRepository;
import com.last_climb.climb.repo.SiteRepository;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private SiteRepository sRep;
	@Autowired
	private CheckOptionalGetObjectService checkAndGet;

	@Autowired
	private CommentaireRepository cRep;

	@Transactional
	@Override
	public void comment(Site s, CommentForm cf) {
		Commentaire com = new Commentaire(cf);

		try {
			Site site = checkAndGet.findANdCheckSiteById(s.getId());
			site.addCom(com);
			sRep.save(site);
			com.setSite(site);
			cRep.save(com);
		} catch (NoSiteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Long id) throws NoCommentaryException {
		Commentaire com = checkAndGet.findANdCheckCommentaireById(id);
		cRep.delete(com);
	}

	@Override
	public void edit(Long id, String commentaire) throws NoCommentaryException {
		Commentaire com = checkAndGet.findANdCheckCommentaireById(id);
		com.setCommentaire(commentaire);
	}

}
