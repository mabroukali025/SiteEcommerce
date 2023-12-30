package ma.project.siteecommerce.services;



import ma.project.siteecommerce.dao.CommandeDao;
import ma.project.siteecommerce.entites.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CommandeService {
    @Autowired
    private CommandeDao commandeDao;

    public List<Commande> findAll(){
        return commandeDao.findAll();
    }
    public int save(Commande commande) {
        if(commande!=null) {
            commandeDao.save(commande);
            return 1;
        }
        else return -1;
    }
    public Commande updateCommande(Long id,Commande commande) {
        Commande c=findById(id).get();
        c.setQuantite(commande.getQuantite());
        commandeDao.save(c);
        return c;
    }

    public Optional<Commande> findById(Long id){
        return commandeDao.findById(id);
    }
    public void deleteById(Long id) {
        commandeDao.deleteById(id);
    }

    public void deleteAll() {
        commandeDao.deleteAll();
    }



}
