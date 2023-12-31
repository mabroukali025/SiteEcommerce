package ma.project.siteecommerce.services;



import ma.project.siteecommerce.dao.ProduitDao;
import ma.project.siteecommerce.entites.Produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class ProduitService {
    @Autowired
    private ProduitDao produitDao;

    public List<Produit> findAll() {
        return produitDao.findAll();
    }


    public Produit save(Produit entity) {
        return produitDao.save(entity);
    }

   

    public Produit updateProduit(Long id, Produit produit) {
        Optional<Produit> optionalProduit = findById(id);

        if (optionalProduit.isPresent()) {
            Produit p = optionalProduit.get();
            p.setRef(produit.getRef());
            p.setDescription(produit.getDescription());
            p.setPrix(produit.getPrix());
            return produitDao.save(p);
        } else {
            // Gérer le cas où le produit n'est pas trouvé, par exemple, lancer une exception.
            throw new RuntimeException("Produit non trouvé pour l'ID : " + id);
        }
    }

    public Optional<Produit> findById(Long id) {
        return produitDao.findById(id);
    }

    public void deleteById(Long id) {
        produitDao.deleteById(id);
    }

    public void deleteAll() {
        produitDao.deleteAll();
    }
    public Produit findProduitByTypeCatrgorie(Produit p) {
    	Produit s;
    	return p;
    }
}
