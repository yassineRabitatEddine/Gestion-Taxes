package com.taxes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taxes.bean.Redevable;
import com.taxes.dao.RedevableDao;
@Service
public class RedevableService {
	@Autowired
	private  RedevableDao redevableDao;

	public Redevable findByCin(String cin) {
		return redevableDao.findByCin(cin);
	}
	@Transactional
	public int deleteByCin(String cin) {
		return redevableDao.deleteByCin(cin);
	}


	public List<Redevable> findAll() {
		return redevableDao.findAll();
	}
	
	public int save(Redevable redevable) {
		if(findByCin(redevable.getCin())!=null) {
			return -1;
		}else {
			redevableDao.save(redevable);
			return 1;
		}
		
	}


}
