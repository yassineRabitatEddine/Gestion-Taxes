package com.taxesejour.springproject3.ws;

import com.taxesejour.springproject3.bean.Local;
import com.taxesejour.springproject3.service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/local")
public class LocalWS {
    @Autowired
    private LocalService localService ;

    @GetMapping("/ref/{ref}")
    public Local findByRef(String ref) {
        return localService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(String ref) {
        return localService.deleteByRef(ref);
    }
    @GetMapping("/cin/{cin}")
    public List<Local> findByRedevableCin(String cin) {
        return localService.findByRedevableCin(cin);
    }
@PostMapping("/")
    public int save(Local local) {
        return localService.save(local);
    }
}
