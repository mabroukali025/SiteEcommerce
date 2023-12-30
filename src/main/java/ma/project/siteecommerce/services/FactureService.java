package ma.project.siteecommerce.services;



import ma.project.siteecommerce.dao.FactureDao;
import ma.project.siteecommerce.entites.Facture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class FactureService {
    @Autowired
    private FactureDao factureDao;
    public List<Facture> findAll(){
        return factureDao.findAll();
    }
    public  int save(Facture facture) {
        if(facture!=null) {
            factureDao.save(facture);
            return 1;
        }
        else return -1;
    }
    public Optional<Facture> findById(Long id) {
        return factureDao.findById(id);
    }
    public void delletCategorieById(Long id) {
        factureDao.deleteById(id);
    }


}
