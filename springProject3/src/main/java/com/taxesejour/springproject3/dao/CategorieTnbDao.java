package com.taxesejour.springproject3.dao;

import com.taxesejour.springproject3.bean.CategorieTnb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieTnbDao extends JpaRepository<CategorieTnb, Long> {

	CategorieTnb findByReference(String reference);
	int deleteByReference(String reference);
}
