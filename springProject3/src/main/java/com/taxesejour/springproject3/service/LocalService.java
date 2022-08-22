package com.taxesejour.springproject3.service;

import com.taxesejour.springproject3.bean.Local;
import com.taxesejour.springproject3.dao.LocalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LocalService {




    @Autowired
    private LocalDao localDao;

    public Local findByRef(String ref) {
        return localDao.findByRef(ref);
    }
    @Transactional
    public int deleteByRef(String ref) {
        return localDao.deleteByRef(ref);
    }

    public List<Local> findByRedevableCin(String cin) {
        return localDao.findByRedevableCin(cin);
    }

    public  int save(Local local) {
        if(findByRef(local.getRef())==null) {return -1;}
        else {
            localDao.save(local);
            return  1;}
    }



}
