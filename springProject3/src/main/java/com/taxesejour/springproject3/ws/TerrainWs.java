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

import com.taxes.bean.Terrain;
import com.taxes.service.TerrainService;

@RestController
@RequestMapping("/api/terrain")
public class TerrainWs {
	@Autowired
	private TerrainService terrainService;
	@GetMapping("/reference/{reference}")
	public Terrain findByReferenceTerrain(@PathVariable String reference) {
		return terrainService.findByReferenceTerrain(reference);
	}
	@DeleteMapping("/reference/{reference}")
	public int deleteByReferenceTerrain(@PathVariable String reference) {
		return terrainService.deleteByReferenceTerrain(reference);
	}
	@GetMapping("/cin/{cin}")
	public List<Terrain> findByRedevableCin(@PathVariable String cin) {
		return terrainService.findByRedevableCin(cin);
	}
	@PostMapping("/")
	public int save(@RequestBody Terrain terrain) {
		return terrainService.save(terrain);
	}
	@GetMapping("/")
	public List<Terrain> findAll() {
		return terrainService.findAll();
	}
	
}
