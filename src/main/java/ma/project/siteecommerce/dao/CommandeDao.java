package ma.project.siteecommerce.dao;

import ma.project.siteecommerce.entites.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeDao  extends JpaRepository<Commande,Long> {

}
