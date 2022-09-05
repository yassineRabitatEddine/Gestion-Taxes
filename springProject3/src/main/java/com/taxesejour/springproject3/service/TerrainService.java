package com.taxes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taxes.bean.Terrain;
import com.taxes.dao.TerrainDao;

@Service
public class TerrainService {
	@Autowired
	private TerrainDao terrainDao;

	public Terrain findByReferenceTerrain(String reference) {
		return terrainDao.findByReferenceTerrain(reference);
	}
	@Transactional
	public int deleteByReferenceTerrain(String reference) {
		return terrainDao.deleteByReferenceTerrain(reference);
	}

	public List<Terrain> findByRedevableCin(String cin) {
		return terrainDao.findByRedevableCin(cin);
	}

	public int save(Terrain terrain) {
		if(findByReferenceTerrain(terrain.getReferenceTerrain())!=null) {
			return -1;
		}else {
			terrainDao.save(terrain);
			return 1;
		}
	}

	public List<Terrain> findAll() {
		return terrainDao.findAll();
	}

}
