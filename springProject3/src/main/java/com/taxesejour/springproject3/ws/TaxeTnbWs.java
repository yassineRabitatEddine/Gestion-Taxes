package com.taxes.ws;

import java.util.List;

import com.taxes.vo.StatistiqueTaxeTnb;
import com.taxes.vo.StatistiqueTnbMinMax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taxes.bean.TaxeTnb;
import com.taxes.proces.TaxeTnbSaveProces;
import com.taxes.service.TaxeTnbService;
@RestController
@RequestMapping("api/taxetnb")
public class TaxeTnbWs {

	@Autowired
	private TaxeTnbService taxeTnbService;
	@Autowired
	private TaxeTnbSaveProces taxeTnbSaveProces;
	
	@PostMapping("/")
	public int save(@RequestBody TaxeTnb taxetnb) {
		taxeTnbSaveProces.exec(taxetnb);
		return 1;
	}
	/*
	 * public List<TaxeTnb> findByLocalReference(@PathVariable String reference) {
	 * return taxeTnbService.findByLocalReference(reference); }
	 */
	@GetMapping("/reference/{reference}")
	public List<TaxeTnb> findByTerrainReferenceTerrain(@PathVariable String reference) {
		return taxeTnbService.findByTerrainReferenceTerrain(reference);
	}
	@GetMapping("/annee/{annee}/reference/{reference}")
	public TaxeTnb findByAnneeAndTerrainReferenceTerrain(@PathVariable int annee, @PathVariable String reference) {
		return taxeTnbService.findByAnneeAndTerrainReferenceTerrain(annee, reference);
	}
	@DeleteMapping("/reference/{reference}")
	public int deleteByTerrainReferenceTerrain(@PathVariable String reference) {
		return taxeTnbService.deleteByTerrainReferenceTerrain(reference);
	}
	@GetMapping("/cinRedevable/{cinRedevable}")
	public List<TaxeTnb> findByTerrainRedevableCin(@PathVariable String cinRedevable) {
		return taxeTnbService.findByTerrainRedevableCin(cinRedevable);
	}
	
	/*
	 * public TaxeTnb findByAnneeAndLocalReference(@PathVariable int
	 * annee, @PathVariable String reference) { return
	 * taxeTnbService.findByAnneeAndLocalReference(annee, reference); }
	 */
	@GetMapping("/annee/{annee}/cin/{cin}")
	public List<TaxeTnb> findByAnneeAndTerrainRedevableCin(@PathVariable int annee, @PathVariable String cin) {
		return taxeTnbService.findByAnneeAndTerrainRedevableCin(annee, cin);
	}
	@GetMapping("/annee/{annee}")
	public List<TaxeTnb> findByAnnee(@PathVariable int annee) {
		return taxeTnbService.findByAnnee(annee);
	}

	@PostMapping("/statistique")
	public List<StatistiqueTaxeTnb> calcStat(@RequestBody StatistiqueTnbMinMax statistiqueTnbMinMax) {
		return taxeTnbService.calcStat(statistiqueTnbMinMax);
	}

	/*
	 * public int deleteByLocalReference(@PathVariable String reference) { return
	 * taxeTnbService.deleteByLocalReference(reference); }
	 */
	
	@GetMapping("/")
	public  List<TaxeTnb> findAll() {
		return taxeTnbService.findAll();
	}

}
