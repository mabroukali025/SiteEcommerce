package ma.project.siteecommerce.dao;

import ma.project.siteecommerce.entites.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieDao  extends JpaRepository<Categorie,Long> {

}
