package com.taxesejour.springproject3.dao;

import com.taxesejour.springproject3.bean.Redevable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedevableDao extends JpaRepository<Redevable,Long> {
    Redevable findByCin(String cin);
    int deleteByCin(String cin);


}
