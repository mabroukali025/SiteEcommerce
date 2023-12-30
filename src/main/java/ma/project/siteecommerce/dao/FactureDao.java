package ma.project.siteecommerce.dao;

import ma.project.siteecommerce.entites.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureDao  extends JpaRepository<Facture,Long> {

}
