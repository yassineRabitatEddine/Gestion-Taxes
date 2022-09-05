package com.taxesejour.springproject3.dao;

import com.taxesejour.springproject3.bean.Taux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TauxDao extends JpaRepository<Taux,Long> {
    Taux findByCategorieLibelle(String Libelle);
    int deleteByCategorieLibelle(String Libelle);


}
