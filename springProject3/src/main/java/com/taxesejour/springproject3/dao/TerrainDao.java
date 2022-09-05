package com.taxes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taxes.bean.Terrain;

@Repository
public interface TerrainDao extends JpaRepository<Terrain, Long> {
	
	Terrain findByReferenceTerrain(String reference);
	int deleteByReferenceTerrain(String reference);
	List<Terrain>findByRedevableCin(String cin);
	

}
