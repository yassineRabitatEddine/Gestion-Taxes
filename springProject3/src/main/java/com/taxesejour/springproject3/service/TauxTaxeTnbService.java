package com.taxesejour.springproject3.service;

import java.util.List;
import java.util.Optional;


import com.taxesejour.springproject3.bean.TauxTaxeTnb;
import com.taxesejour.springproject3.dao.TauxTaxeTnbDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TauxTaxeTnbService {
	@Autowired
	private TauxTaxeTnbDao tauxTaxeTnbDao;

	public TauxTaxeTnb findByCategorieTnbReference(String reference) {
		return tauxTaxeTnbDao.findByCategorieTnbReference(reference);
	}

	@Transactional
	public int deleteByCategorieTnbReference(String reference) {
		return tauxTaxeTnbDao.deleteByCategorieTnbReference(reference);
	}

	public List<TauxTaxeTnb> findAll() {
		return tauxTaxeTnbDao.findAll();
	}
	
	public int save(TauxTaxeTnb tauxtaxetnb) {
		if(findByCategorieTnbReference(tauxtaxetnb.getCategorieTnb().getReference())!=null) {
			return -1;
		}else {
		tauxTaxeTnbDao.save(tauxtaxetnb);
		return 1;
		}
	}

}
