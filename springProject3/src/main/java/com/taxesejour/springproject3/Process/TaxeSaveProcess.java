package com.taxesejour.springproject3.Process;

import com.taxesejour.springproject3.bean.Local;
import com.taxesejour.springproject3.bean.Redevable;
import com.taxesejour.springproject3.bean.Taux;
import com.taxesejour.springproject3.bean.Taxe;
import com.taxesejour.springproject3.dao.TaxeDao;
import com.taxesejour.springproject3.service.LocalService;
import com.taxesejour.springproject3.service.RedevableService;
import com.taxesejour.springproject3.service.TauxService;
import com.taxesejour.springproject3.service.TaxeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxeSaveProcess {
    @Autowired
    private TauxService tauxService;
    @Autowired
    private TaxeDao taxeDao;
    @Autowired
    private RedevableService redevableService;
    @Autowired
    private  LocalService localService ;
    @Autowired
    private TaxeService taxeService;

   public void init(Taxe taxe){
       if(taxe!=null){
           if(taxe.getRedevable()!=null){
               Redevable redevable = redevableService.findByCin(taxe.getRedevable().getCin());
               taxe.setRedevable(redevable);
           }
           if(taxe.getLocal()!=null){}
                Local local = localService.findByRef(taxe.getLocal().getRef());
                taxe.setLocal(local);
       }
       if(taxe.getLocal()!=null && taxe.getLocal().getCategorie()!=null){

           Taux taux = tauxService.findByCategorieLibelle(taxe.getLocal().getCategorie().getLibelle());
           taxe.setTaux(taux);
       }

   }
   public int validate(Taxe taxe){
       if(taxe.getRedevable()==null){return -1;}
       else if(taxe.getLocal()==null) {return -1;}
       else if(taxe.getTaux()==null){return -3;}
       else if(taxe.getLocal().getCategorie()==null){return -4;}
       else if (taxeService.findByAnnee(taxe.getAnnee())==null){return -5;}
       else return 1;
   }
   public void exec(Taxe taxe){
       double montant = taxe.getCA()* taxe.getTaux().getPourcentage();
       taxe.setMontantBase(montant);
       taxeDao.save(taxe);
   }
   public  int save(Taxe taxe){
       init(taxe);
       int res = validate(taxe);
       if(res>0) {exec(taxe);}
       else {return res;}
   }
}
