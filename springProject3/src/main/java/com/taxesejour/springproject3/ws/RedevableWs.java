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

import com.taxes.bean.Redevable;
import com.taxes.service.RedevableService;

@RestController
@RequestMapping("/api/Redevable")
public class RedevableWs {
	@Autowired
	public RedevableService redevableService;
	
	@GetMapping("/cin/{cin}")
	public Redevable findByCin(@PathVariable String cin) {
		return redevableService.findByCin(cin);
	}
	@DeleteMapping("/cin/{cin}")
	public int deleteByCin(@PathVariable String cin) {
		return redevableService.deleteByCin(cin);
	}
	@GetMapping("/")
	public List<Redevable> findAll() {
		return redevableService.findAll();
	}
	@PostMapping("/")
	public int save(@RequestBody Redevable redevable) {
		return redevableService.save(redevable);
	}

}
