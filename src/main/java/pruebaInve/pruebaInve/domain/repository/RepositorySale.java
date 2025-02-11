package pruebaInve.pruebaInve.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pruebaInve.pruebaInve.domain.model.Sale;

import java.util.Optional;

@Repository
public interface RepositorySale extends JpaRepository<Sale,Integer>{

    @Override
    Optional<Sale> findById(Integer id);
}
