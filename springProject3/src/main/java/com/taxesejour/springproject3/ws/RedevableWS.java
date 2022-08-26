package com.taxesejour.springproject3.ws;

import com.taxesejour.springproject3.bean.Redevable;
import com.taxesejour.springproject3.service.RedevableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/redevable")
public class RedevableWS {
    @Autowired
    private RedevableService redevableService;
    @GetMapping("/cin/{cin}")
    public Redevable findByCin(@PathVariable String cin) {
        return redevableService.findByCin(cin);
    }

    @DeleteMapping("/cin/{cin}")
    public int deleteByCin(@PathVariable String cin) {
        return redevableService.deleteByCin(cin);
    }
@PostMapping("/")
    public int save(@RequestBody Redevable redevable) {
        return redevableService.save(redevable);
    }
}
