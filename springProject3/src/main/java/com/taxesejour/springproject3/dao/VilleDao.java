package com.taxesejour.springproject3.dao;
import com.taxesejour.springproject3.bean.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface VilleDao extends  JpaRepository<Ville,Long> {
    Ville findByRef(String Ref);
    Ville deleteByRef(String Ref);
    List<Ville> findByRefLikeAndGreaterThan(String Ref);
}
