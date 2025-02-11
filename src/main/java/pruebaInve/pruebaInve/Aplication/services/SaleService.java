package pruebaInve.pruebaInve.aplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pruebaInve.pruebaInve.domain.model.Sale;
import pruebaInve.pruebaInve.domain.repository.RepositoryProduct;
import pruebaInve.pruebaInve.domain.repository.RepositorySale;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class SaleService {
    @Autowired
    private RepositorySale repositorySale;
@Autowired
    private RepositoryProduct repositoryProduct;

    public List<Sale> searchSale(){
        return  this.repositorySale.findAll();
    }

     public Optional<Sale> searchSaleId (Integer id){
         return this.repositorySale.findById(id);
     }


     public ResponseEntity<Sale> save (Sale sale ){

         BigDecimal amount = BigDecimal.valueOf(sale.getAmount());
         BigDecimal price = BigDecimal.valueOf(sale.getPrice());
         BigDecimal total = amount.multiply(price);
         sale.setTotal(total);

         Sale saveSale = repositorySale.save(sale);
         return new ResponseEntity<>(saveSale, HttpStatus.CREATED);

     }



     public ResponseEntity<Sale> delete (Integer id){
         Optional<Sale> searchSale= repositorySale.findById(id);

         if (searchSale.isPresent()){
             repositorySale.deleteById(id);
             return ResponseEntity.ok(searchSale.get());
         }
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
     }
}
