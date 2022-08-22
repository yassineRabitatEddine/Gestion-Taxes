package com.taxesejour.springproject3.dao;

import com.taxesejour.springproject3.bean.Rue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RueDao extends JpaRepository<Rue,Long> {
    Rue findByRef (String ref);
    Rue deleteByRef(String ref);
    List<Rue> findByRefLikeAndGreaterThan(String ref);
}
