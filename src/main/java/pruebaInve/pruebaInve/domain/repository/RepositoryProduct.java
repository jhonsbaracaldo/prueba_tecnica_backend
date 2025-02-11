package pruebaInve.pruebaInve.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pruebaInve.pruebaInve.domain.model.Product;


import java.util.Optional;
@Repository
public interface RepositoryProduct extends JpaRepository<Product, Integer> {

   @Override
    Optional<Product> findById(Integer id);
}
