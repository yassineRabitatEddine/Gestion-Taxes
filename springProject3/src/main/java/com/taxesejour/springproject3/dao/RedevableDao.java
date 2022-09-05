package com.taxes.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taxes.bean.Redevable;
@Repository
public interface RedevableDao extends JpaRepository<Redevable, Long> {

	Redevable findByCin(String cin);
	int deleteByCin(String cin);
}
