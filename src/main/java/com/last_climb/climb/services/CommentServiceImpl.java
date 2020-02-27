package com.last_climb.climb.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.last_climb.climb.model.entity.Commentaire;
import com.last_climb.climb.model.entity.Site;
import com.last_climb.climb.model.form.CommentForm;
import com.last_climb.climb.repo.CommentaireRepository;
import com.last_climb.climb.repo.SiteRepository;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private SiteRepository sRep;

	@Autowired
	private CommentaireRepository cRep;

	@Transactional
	@Override
	public void comment(Site s, CommentForm cf) {
		Commentaire com = new Commentaire(cf);
		Optional<Site> site = sRep.findById(s.getId());
		Site persistSite = site.get();
		persistSite.addCom(com);
		sRep.save(s);
		com.setSite(s);
		cRep.save(com);
	}

}
