package ma.project.siteecommerce.controllers;


import ma.project.siteecommerce.entites.Categorie;
import ma.project.siteecommerce.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/categorie")
public class CategorieController {

@Autowired
    private CategorieService categorieService;
    @GetMapping("/all")
    public List<Categorie> findAll(){
        return categorieService.findAll();
    }
    @PostMapping("/save")
    public Categorie save(@RequestBody Categorie categorie) {
        return categorieService.save(categorie);
    }
    @GetMapping("/{id}")
    public Optional<Categorie> findById(@PathVariable("id")Long id){
        return categorieService.findById(id);
    }
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        categorieService.delletCategorieById(id);
    }

    @PutMapping("id/{id}")
    public Categorie update(@PathVariable Long id,@RequestBody Categorie categorie) {
        return categorieService.updateCategorie(id, categorie);
    }

}
