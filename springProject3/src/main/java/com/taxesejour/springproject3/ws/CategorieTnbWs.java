package com.taxesejour.springproject3.ws;

import java.util.List;

import com.taxesejour.springproject3.bean.CategorieTnb;
import com.taxesejour.springproject3.service.CategorieTnbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/categorietnb")
public class CategorieTnbWs {
	@Autowired
	private CategorieTnbService categorieTnbService;
	@GetMapping("/reference/{reference}")
	public CategorieTnb findByReference(@PathVariable String reference) {
		return categorieTnbService.findByReference(reference);
	}
	@DeleteMapping("/reference/{reference}")
	public int deleteByReference(@PathVariable String reference) {
		return categorieTnbService.deleteByReference(reference);
	}
	@GetMapping("/")
	public List<CategorieTnb> findAll() {
		return categorieTnbService.findAll();
	}
	@PostMapping("/")
	public int save(@RequestBody CategorieTnb categorietnb) {
		return categorieTnbService.save(categorietnb);
	}
}
