package ma.project.siteecommerce.dao;

import ma.project.siteecommerce.entites.Facture;
import ma.project.siteecommerce.entites.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitDao  extends JpaRepository<Produit,Long> {

}
