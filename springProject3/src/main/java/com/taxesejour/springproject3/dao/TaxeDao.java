package com.taxesejour.springproject3.dao;

import com.taxesejour.springproject3.bean.Taxe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaxeDao extends JpaRepository<Taxe, Long> {
    //Trouver l'ensemble des taxes pour un local
    List<Taxe> findByLocalRef(String ref);
    //Trouver l'ensemble des taxes pour un redevable
    List<Taxe> findByRedevableCin(String cinredevable);
    //taxes payées dans l'annee x pour le local y
    List<Taxe> findByAnneeAndLocalRef(int annee, String ref);
    List<Taxe> findByAnnee (int annee);

    List<Taxe> findByAnneeAndRedevableCin(int annee, String cin);
    int deleteByLocalRef(String ref);
}
