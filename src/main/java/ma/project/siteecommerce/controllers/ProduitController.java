package ma.project.siteecommerce.controllers;




import ma.project.siteecommerce.entites.Categorie;
import ma.project.siteecommerce.entites.Produit;
import ma.project.siteecommerce.services.CategorieService;
import ma.project.siteecommerce.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/produit")

public class ProduitController {
@Autowired
    private ProduitService produitService;
    @Autowired
    private CategorieService categorieService;
    @GetMapping("/all")
    public List<Produit> findAll() {
        return produitService.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveProduit(
            @RequestParam("ref") String ref,
            @RequestParam("nom") String nom,
            @RequestParam("qte") int qte,
            @RequestParam("prix") Double prix,
            @RequestParam("description") String description,
            @RequestParam("categorieId") Long categorieId,
            @RequestParam("imageBon") MultipartFile imageBon) {

        try {
            // Valider les données si nécessaire (par exemple, vérifier si des champs obligatoires sont vides)

            Produit produit = new Produit();
            produit.setRef(ref);
            produit.setNom(nom);
            produit.setQte(qte);
            produit.setPrix(prix);
            produit.setDescription(description);

            // Récupérer la catégorie à partir de la base de données en utilisant son identifiant
            Categorie categorie = categorieService.findById(categorieId)
                    .orElseThrow(() -> new RuntimeException("La catégorie avec l'ID " + categorieId + " n'existe pas"));
            produit.setCategories(categorie); // Modifier setCategorie en fonction du nom du setter réel

            if (imageBon != null && !imageBon.isEmpty()) {
                produit.setImageBon(imageBon.getBytes());
            }

            // Utiliser le service de produit pour sauvegarder le produit
            Produit savedProduit = produitService.save(produit);

            // Si la sauvegarde est réussie, retourner le produit sauvegardé avec un statut 200
            return new ResponseEntity<>(savedProduit, HttpStatus.OK);
        } catch (Exception e) {
            // Gérer toute exception survenue pendant la sauvegarde
            return new ResponseEntity<>("Erreur lors de la sauvegarde du produit : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/{id}")
    public Optional<Produit> findById(@PathVariable("id")Long id) {
        return produitService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        produitService.deleteById(id);
    }

    @PutMapping("id/{id}")
    public Produit update(@PathVariable Long id, @RequestBody Produit produit) {
        return produitService.updateProduit(id, produit);
    }
}
