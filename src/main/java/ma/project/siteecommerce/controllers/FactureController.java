package ma.project.siteecommerce.controllers;

import ma.project.siteecommerce.entites.Facture;
import ma.project.siteecommerce.services.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/facture")
public class FactureController {
    @Autowired
    private FactureService factureService;
    @GetMapping("/all")
    public List<Facture> findAll() {
        return factureService.findAll();
    }

    @PostMapping("/save")
    public int save(@RequestBody Facture f) {
        return factureService.save(f);
    }

    @GetMapping("/{id}")
    public Optional<Facture> findById(@PathVariable("id")Long id) {
        return factureService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        factureService.delletCategorieById(id);
    }

	   /* @PutMapping("id/{id}")
	    public Facture update(@PathVariable Long id, @RequestBody Facture facture) {
	        return FactureService.updateProduit(id,facture);
	    }*/

}
