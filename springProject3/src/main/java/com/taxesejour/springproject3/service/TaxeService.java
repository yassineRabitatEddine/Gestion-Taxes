package com.taxesejour.springproject3.service;


import com.taxesejour.springproject3.bean.Taxe;
import com.taxesejour.springproject3.dao.TaxeDao;
import com.taxesejour.springproject3.proces.TaxeSaveProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxeService {
    public int deleteByLocalRef(String ref) {
        return taxedao.deleteByLocalRef(ref);
    }

    public List<Taxe> findByAnneeAndRedevableCin(int annee, String cin) {
        return taxedao.findByAnneeAndRedevableCin(annee, cin);
    }


    @Autowired
    private TaxeDao taxedao;
    @Autowired
    private TaxeSaveProcess taxeSaveProcess;


    public List<Taxe> findByLocalRef(String ref) {
        return taxedao.findByLocalRef(ref);
    }

    public List<Taxe> findByRedevableCin(String cinredevable) {
        return taxedao.findByRedevableCin(cinredevable);
    }

    public List<Taxe> findByAnneeAndAndLocalRef(int annee, String ref) {
        return taxedao.findByAnneeAndLocalRef(annee, ref);
    }


    public List<Taxe> findByAnnee(int annee) {
        return taxedao.findByAnnee(annee);
    }






    public int save(Taxe taxe) {
        int res = taxeSaveProcess.save(taxe);
        return res;
    }


}
