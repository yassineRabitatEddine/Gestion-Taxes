package com.taxesejour.springproject3.dao;

import java.util.List;

import com.taxesejour.springproject3.bean.TaxeTnb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaxeTnbDao extends JpaRepository<TaxeTnb,Long>{
	
	//List<TaxeTnb> findByLocalReference(String reference);
	List<TaxeTnb> findByTerrainReferenceTerrain(String reference);
	List<TaxeTnb> findByTerrainRedevableCin(String cinRedevable);
	//TaxeTnb findByAnneeAndLocalReference(int annee, String reference); 
	TaxeTnb findByAnneeAndTerrainReferenceTerrain(int annee, String reference); 

	List<TaxeTnb> findByAnneeAndTerrainRedevableCin(int annee, String cin);
	List<TaxeTnb> findByAnnee(int annee);	
	//int deleteByLocalReference(String reference);
	int deleteByTerrainReferenceTerrain(String reference);
	
}
