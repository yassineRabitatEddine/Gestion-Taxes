package com.taxesejour.springproject3.service;

import com.taxesejour.springproject3.bean.Categorie;
import com.taxesejour.springproject3.dao.CategorieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CategorieService {



    @Autowired
    private CategorieDao categorieDao ;

    public Categorie findByLibelle(String Libelle) {
        return categorieDao.findByLibelle(Libelle);
    }
    @Transactional
    public int deleteByLibelle(String Libelle) {
        return categorieDao.deleteByLibelle(Libelle);
    }

    public int  save(Categorie categorie) {

        if(findByLibelle(categorie.getLibelle() )!= null) {return -1;}

         else {
            categorieDao.save(categorie);
            return 1;
        }
    }




}
