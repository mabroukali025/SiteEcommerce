package ma.project.siteecommerce.controllers;


import ma.project.siteecommerce.entites.Commande;
import ma.project.siteecommerce.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/commande")
public class CommandeController {
    @Autowired
    private CommandeService commandeService;

    @GetMapping("/all")
    public List<Commande> findAll(){
        return commandeService.findAll();
    }
    @PostMapping("")
    public int save(@RequestBody Commande commande) {
        return commandeService.save(commande);
    }
    @GetMapping("/{id}")
    public Optional<Commande> findById(@PathVariable("id")Long id){
        return commandeService.findById(id);
    }
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        commandeService.deleteById(id);
    }

    @PutMapping("id/{id}")
    public Commande update(@PathVariable Long id,@RequestBody Commande commande) {
        return commandeService.updateCommande(id, commande);
    }

}
