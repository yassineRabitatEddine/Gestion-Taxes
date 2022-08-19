package com.taxesejour.springproject3.dao;


import com.taxesejour.springproject3.bean.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalDao  extends JpaRepository<Local,Long> {
    Local findByRef(String ref);
    int deleteByRef(String ref);
    List<Local> findByRedevableCin(String cin);

}
