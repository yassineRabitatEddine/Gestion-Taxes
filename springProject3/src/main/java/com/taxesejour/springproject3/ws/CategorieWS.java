package com.taxesejour.springproject3.ws;

import com.taxesejour.springproject3.bean.Categorie;
import com.taxesejour.springproject3.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
@RestController
@RequestMapping("/api/categorie")
public class CategorieWS {

    @Autowired
    private CategorieService categorieService ;

    @GetMapping("/Libelle/{Libelle}")
    public Categorie findByLibelle(@PathVariable String Libelle) {
        return categorieService.findByLibelle(Libelle);
    }

    @DeleteMapping("/")
    public int deleteByLibelle(@RequestBody categDelInfo categDelInfo) {
        return categorieService.deleteByLibelle(categDelInfo.getLibelle());
    }
    @PostMapping("/")
    public int save(@RequestBody Categorie categorie) {
        return categorieService.save(categorie);
    }
}
