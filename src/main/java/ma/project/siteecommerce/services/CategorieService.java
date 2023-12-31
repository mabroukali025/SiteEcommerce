package ma.project.siteecommerce.services;


import ma.project.siteecommerce.dao.CategorieDao;
import ma.project.siteecommerce.entites.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CategorieService {
    @Autowired
    private CategorieDao categorieDao;

    public List<Categorie> findAll(){
        return categorieDao.findAll();
    }

    public  Categorie  save(Categorie categorie) {
        return categorieDao.save(categorie);
    }

    public Categorie updateCategorie(Long id, Categorie categorie) {
        Optional<Categorie> optionalCategorie = findById(id);
        if (optionalCategorie.isPresent()) {
            Categorie cat = optionalCategorie.get();
            cat.setType(categorie.getType());
            cat.setDescription(categorie.getDescription());
            return categorieDao.save(cat);
        } else {
            // Gérer le cas où la catégorie n'est pas trouvée, par exemple, lancer une exception.
            throw new RuntimeException("Catégorie non trouvée pour l'ID : " + id);
        }
    }

    public Optional<Categorie> findById(Long id) {
        return categorieDao.findById(id);
    }
    public void delletCategorieById(Long id) {
        categorieDao.deleteById(id);
    }

}
