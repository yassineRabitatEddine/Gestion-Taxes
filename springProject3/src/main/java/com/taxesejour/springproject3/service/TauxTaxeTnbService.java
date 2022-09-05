package com.taxes.service;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taxes.bean.TauxTaxeTnb;
import com.taxes.dao.TauxTaxeTnbDao;
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
