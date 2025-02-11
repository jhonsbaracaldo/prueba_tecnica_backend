package pruebaInve.pruebaInve.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pruebaInve.pruebaInve.domain.model.Seller;

import java.util.Optional;

@Repository
public interface RepositorySeller extends JpaRepository<Seller,Long> {

    @Override
    Optional<Seller> findById(Long id);
}
