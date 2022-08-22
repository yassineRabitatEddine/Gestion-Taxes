package com.taxesejour.springproject3.service;

import com.taxesejour.springproject3.bean.Redevable;
import com.taxesejour.springproject3.dao.RedevableDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RedevableService {


    @Autowired
    private RedevableDao redevableDao ;

    public Redevable findByCin(String cin) {
        return redevableDao.findByCin(cin);
    }

    @Transactional
    public int deleteByCin(String cin) {
        return redevableDao.deleteByCin(cin);
    }

    public int save(Redevable redevable) {
        if(findByCin(redevable.getCin())==null) {return -1;}
        else {

        redevableDao.save(redevable);
        return 1;}
    }


}
