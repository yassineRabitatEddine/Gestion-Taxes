package com.taxesejour.springproject3.dao;

import com.taxesejour.springproject3.bean.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieDao extends JpaRepository<Categorie,Long> {
    Categorie findByLibelle(String Libelle);
    int deleteByLibelle(String Libelle);

}
