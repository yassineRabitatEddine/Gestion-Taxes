package com.taxes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taxes.bean.TauxTaxeTnb;
@Repository
public interface TauxTaxeTnbDao extends JpaRepository<TauxTaxeTnb, Long> {

	TauxTaxeTnb findByCategorieTnbReference(String reference);
	int deleteByCategorieTnbReference(String reference);
}
