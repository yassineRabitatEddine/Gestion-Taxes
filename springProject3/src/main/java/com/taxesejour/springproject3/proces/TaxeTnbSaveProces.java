package com.taxes.proces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxes.bean.Redevable;
import com.taxes.bean.TauxTaxeTnb;
import com.taxes.bean.TaxeTnb;
import com.taxes.bean.Terrain;
import com.taxes.dao.TaxeTnbDao;
import com.taxes.service.RedevableService;
import com.taxes.service.TauxTaxeTnbService;
import com.taxes.service.TerrainService;

@Service
public class TaxeTnbSaveProces {
	@Autowired
	private TaxeTnbDao taxetnbdao;
	@Autowired
	private RedevableService redevableService;
	@Autowired
	private TerrainService terrainService;
	//private LocalService localService;
	
	@Autowired
	private TauxTaxeTnbService tauxTaxeTnbService;
	
	public int save(TaxeTnb taxetnb) {
		initSave(taxetnb);
		int res = validateSave(taxetnb);
		if(res>0) {
			exec(taxetnb);
		}
		return res;
	}

	public void exec(TaxeTnb taxetnb) {
		// TODO Auto-generated method stub
		double montant = taxetnb.getTerrain().getSurface()*taxetnb.getTauxTaxeTnb().getMontantMetreCarre();
		taxetnb.setMontantBase(montant);
		taxetnbdao.save(taxetnb);
	}

	public int validateSave(TaxeTnb taxetnb) {
		// TODO Auto-generated method stub
		if(taxetnb.getTerrain().getRedevavble()==null) {
			return -1;
		}else if (taxetnb.getTerrain()==null) {
			return -2;
		}else if (taxetnb.getTerrain().getCategorieTnb()==null) {
		return -3;
		}else if(taxetnb.getTauxTaxeTnb()==null){
			return -4;
		}else {
			return 1;
		}
	}
		

	public void initSave(TaxeTnb taxetnb) {
		// TODO Auto-generated method stub
		Redevable redev = redevableService.findByCin(taxetnb.getTerrain().getRedevavble().getCin());
		taxetnb.getTerrain().setRedevable(redev);
		Terrain terrain = terrainService.findByReferenceTerrain(taxetnb.getTerrain().getReferenceTerrain());
		taxetnb.setTerrain(terrain);
		TauxTaxeTnb taux = tauxTaxeTnbService.findByCategorieTnbReference(taxetnb.getTerrain().getCategorieTnb().getReference());
		taxetnb.setTauxTaxeTnb(taux);
	}
}
