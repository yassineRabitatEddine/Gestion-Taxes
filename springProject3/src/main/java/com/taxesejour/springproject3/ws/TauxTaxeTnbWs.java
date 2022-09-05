package com.taxes.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taxes.bean.TauxTaxeTnb;
import com.taxes.service.TauxTaxeTnbService;

@RestController
@RequestMapping("/api/tauxtaxetnb")
public class TauxTaxeTnbWs {
	@Autowired
	private TauxTaxeTnbService tauxTaxeTnbService;

	@GetMapping("/reference/{reference}")
	public TauxTaxeTnb findByCategorieTnbReference(@PathVariable String reference) {
		return tauxTaxeTnbService.findByCategorieTnbReference(reference);
	}
	@DeleteMapping("/reference/{reference}")
	public int deleteByCategorieTnbReference(@PathVariable String reference) {
		return tauxTaxeTnbService.deleteByCategorieTnbReference(reference);
	}
	@GetMapping("/")
	public List<TauxTaxeTnb> findAll() {
		return tauxTaxeTnbService.findAll();
	}
	@PostMapping("/")
	public int save(@RequestBody TauxTaxeTnb tauxtaxetnb) {
		return tauxTaxeTnbService.save(tauxtaxetnb);
	}
	
}
