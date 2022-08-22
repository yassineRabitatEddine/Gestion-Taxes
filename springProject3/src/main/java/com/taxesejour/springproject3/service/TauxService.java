package com.taxesejour.springproject3.service;

import com.taxesejour.springproject3.bean.Taux;
import com.taxesejour.springproject3.dao.TauxDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TauxService {


    @Autowired
    private TauxDao tauxDao ;

    public Taux findByCategorieLibelle(String Libelle) {
        return tauxDao.findByCategorieLibelle(Libelle);
    }
    @Transactional
    public int deleteByCategorieLibelle(String Libelle) {
        return tauxDao.deleteByCategorieLibelle(Libelle);
    }

    public int save(Taux taux ) {
        if(findByCategorieLibelle(taux.getCategorie().getLibelle())==null){return -1;}
        else {
         tauxDao.save(taux);
        return 1;}
    }



}
