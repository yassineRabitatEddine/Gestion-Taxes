package com.taxes.service;

import java.util.List;
import java.util.Optional;

import com.taxes.vo.StatistiqueTaxeTnb;
import com.taxes.vo.StatistiqueTnbMinMax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taxes.bean.TaxeTnb;
import com.taxes.dao.TaxeTnbDao;
import com.taxes.proces.TaxeTnbSaveProces;

import javax.persistence.EntityManager;

@Service
public class TaxeTnbService {
	@Autowired
	private TaxeTnbDao taxetnbdao;
	@Autowired
	TaxeTnbSaveProces taxeTnbSaveProces;

	/*
	 * public List<TaxeTnb> findByLocalReference(String reference) { return
	 * taxetnbdao.findByLocalReference(reference); }
	 */

	@Autowired
	private EntityManager entityManager;

	public List<TaxeTnb> findByTerrainReferenceTerrain(String reference) {
		return taxetnbdao.findByTerrainReferenceTerrain(reference);
	}

	public TaxeTnb findByAnneeAndTerrainReferenceTerrain(int annee, String reference) {
		return taxetnbdao.findByAnneeAndTerrainReferenceTerrain(annee, reference);
	}

	@Transactional
	public int deleteByTerrainReferenceTerrain(String reference) {
		return taxetnbdao.deleteByTerrainReferenceTerrain(reference);
	}


	public List<StatistiqueTaxeTnb> calcStat(StatistiqueTnbMinMax statistiqueTnbMinMax ){
		String query="SELECT NEW com.taxes.vo.StatistiqueTaxeTnb(t.annee,SUM(t.montantBase)) FROM TaxeTnb t WHERE 1=1 ";
		if(statistiqueTnbMinMax.getAnneMin()!=null)
			query+= " AND t.annee >= " +statistiqueTnbMinMax.getAnneMin();
		if (statistiqueTnbMinMax.getAnneMax()!=null)
			query+=" AND t.annee <= " + statistiqueTnbMinMax.getAnneMax();


			query+=" GROUP BY t.annee";
		System.out.println("query = " + query);

		return entityManager.createQuery(query).getResultList();
	}

	public List<TaxeTnb> findByTerrainRedevableCin(String cinRedevable) {
		return taxetnbdao.findByTerrainRedevableCin(cinRedevable);
	}

	/*
	 * public TaxeTnb findByAnneeAndLocalReference(int annee, String reference) {
	 * return taxetnbdao.findByAnneeAndLocalReference(annee, reference); }
	 */

	public List<TaxeTnb> findByAnneeAndTerrainRedevableCin(int annee, String cin) {
		return taxetnbdao.findByAnneeAndTerrainRedevableCin(annee, cin);
	}

	public List<TaxeTnb> findByAnnee(int annee) {
		return taxetnbdao.findByAnnee(annee);
	}


	public List<TaxeTnb> findAll() {
		return taxetnbdao.findAll();
	}
	
	public int save(TaxeTnb taxeTnb) {
		int n=taxeTnbSaveProces.save(taxeTnb);
		return n;
	}
	
}
