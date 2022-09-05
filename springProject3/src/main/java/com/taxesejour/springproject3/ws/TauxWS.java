package com.taxesejour.springproject3.ws;

import com.taxesejour.springproject3.bean.Taux;
import com.taxesejour.springproject3.service.TauxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/taux")
public class TauxWS {
    @Autowired
    private TauxService tauxService;
    @GetMapping("/Libelle/{Libelle}")
    public Taux findByCategorieLibelle(String Libelle) {
        return tauxService.findByCategorieLibelle(Libelle);
    }

    @DeleteMapping("/Libelle/{Libelle}")
    public int deleteByCategorieLibelle(String Libelle) {
        return tauxService.deleteByCategorieLibelle(Libelle);
    }
@PostMapping("/")
    public int save(Taux taux) {
        return tauxService.save(taux);
    }
}
