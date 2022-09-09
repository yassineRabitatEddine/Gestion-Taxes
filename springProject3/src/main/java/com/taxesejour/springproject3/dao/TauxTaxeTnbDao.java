package com.taxesejour.springproject3.dao;

import com.taxesejour.springproject3.bean.TauxTaxeTnb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TauxTaxeTnbDao extends JpaRepository<TauxTaxeTnb, Long> {

	TauxTaxeTnb findByCategorieTnbReference(String reference);
	int deleteByCategorieTnbReference(String reference);
}
