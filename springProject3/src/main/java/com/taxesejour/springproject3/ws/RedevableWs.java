package com.taxesejour.springproject3.ws;

import java.util.List;

import com.taxesejour.springproject3.bean.Redevable;
import com.taxesejour.springproject3.service.RedevableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/redevable")
public class RedevableWs {
	@Autowired
	public RedevableService redevableService;
	
	@GetMapping("/cin/{cin}")
	public Redevable findByCin(@PathVariable String cin) {
		return redevableService.findByCin(cin);
	}
	@DeleteMapping("/")
	public int deleteByCin(@RequestBody redevDelINfo redevDelINfo) {
		return redevableService.deleteByCin(redevDelINfo.getCin());
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
