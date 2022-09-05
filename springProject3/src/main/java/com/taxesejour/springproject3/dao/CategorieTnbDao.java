package com.taxes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taxes.bean.CategorieTnb;
@Repository
public interface CategorieTnbDao extends JpaRepository<CategorieTnb, Long> {

	CategorieTnb findByReference(String reference);
	int deleteByReference(String reference);
}
