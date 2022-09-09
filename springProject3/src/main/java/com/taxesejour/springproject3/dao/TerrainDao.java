package com.taxesejour.springproject3.dao;

import java.util.List;

import com.taxesejour.springproject3.bean.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TerrainDao extends JpaRepository<Terrain, Long> {
	
	Terrain findByReferenceTerrain(String reference);
	int deleteByReferenceTerrain(String reference);
	List<Terrain>findByRedevableCin(String cin);
	

}
