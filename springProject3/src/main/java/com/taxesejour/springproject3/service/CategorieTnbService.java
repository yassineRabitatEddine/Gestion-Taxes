package com.taxes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taxes.bean.CategorieTnb;
import com.taxes.dao.CategorieTnbDao;
@Service
public class CategorieTnbService {
	@Autowired
	private CategorieTnbDao categorieTnbDao;

	public CategorieTnb findByReference(String reference) {
		return categorieTnbDao.findByReference(reference);
	}
	@Transactional
	public int deleteByReference(String reference) {
		return categorieTnbDao.deleteByReference(reference);
	}


	public List<CategorieTnb> findAll() {
		return categorieTnbDao.findAll();
	}
	
	public int save(CategorieTnb categorietnb) {
		if(findByReference(categorietnb.getReference())!=null) {
			return -1;
		}else {
			categorieTnbDao.save(categorietnb);
			return 1;
		}
	}
		

}
