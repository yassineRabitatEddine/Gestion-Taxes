package com.taxesejour.springproject3.ws;

import com.taxesejour.springproject3.bean.Taxe;
import com.taxesejour.springproject3.proces.TaxeSaveProcess;
import com.taxesejour.springproject3.service.TaxeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taxe")
public class TaxeWS {
    @Autowired
    private TaxeService taxeService;
    @Autowired
    private TaxeSaveProcess taxeSaveProcess;

    @DeleteMapping("/ref/{ref}")
    public int deleteByLocalRef(String ref) {
        return taxeService.deleteByLocalRef(ref);
    }
    @GetMapping("anne/{anne}/cin/{cin}")
    public List<Taxe> findByAnneeAndRedevableCin(@PathVariable int annee,@PathVariable String cin) {
        return taxeService.findByAnneeAndRedevableCin(annee, cin);
    }
    @GetMapping("/ref/{ref}")
    public List<Taxe> findByLocalRef(@PathVariable String ref) {
        return taxeService.findByLocalRef(ref);
    }
    @GetMapping("/cin/{cin}")
    public List<Taxe> findByRedevableCin(@PathVariable String cinredevable) {
        return taxeService.findByRedevableCin(cinredevable);
    }
    @GetMapping("anne/{anne}/ref/{ref}")
    public List<Taxe> findByAnneeAndAndLocalRef(@PathVariable int annee,@PathVariable String ref) {
        return taxeService.findByAnneeAndAndLocalRef(annee, ref);
    }
    @GetMapping("anne/{anne}")
    public List<Taxe> findByAnnee(@PathVariable int annee) {
        return taxeService.findByAnnee(annee);
    }


    @PostMapping("/")
    public int save(Taxe taxe) {
        return taxeService.save(taxe);
    }
}
