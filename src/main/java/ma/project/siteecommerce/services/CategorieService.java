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
        Categorie cat=findById(id).get();
        cat.setType(categorie.getType());
        cat.setDescription(categorie.getDescription());
        categorieDao.save(cat);
        return cat;
    }
    public Optional<Categorie> findById(Long id) {
        return categorieDao.findById(id);
    }
    public void delletCategorieById(Long id) {
        categorieDao.deleteById(id);
    }

}
