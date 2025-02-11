package pruebaInve.pruebaInve.aplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pruebaInve.pruebaInve.domain.model.Seller;
import pruebaInve.pruebaInve.domain.repository.RepositorySeller;

import java.util.List;
import java.util.Optional;

@Service
public class SellerService {

    @Autowired
    private RepositorySeller repositorySeller;
    public List<Seller> sellerAll (){
        return this.repositorySeller.findAll();
    }

     public List<Seller> sellerId (Long id){
         repositorySeller.findById(id);
         return sellerId(id);
     }

     public ResponseEntity<Seller> save (Seller seller){
         Seller saveSeller  = repositorySeller.save(seller);
         return  new ResponseEntity<>(saveSeller,HttpStatus.CREATED);
     }

     public ResponseEntity<Seller> update (Long id, Seller seller){
         Optional<Seller> searchSeller = repositorySeller.findById(id);

         if(searchSeller.isPresent()){
             Seller updateS = searchSeller.get();

             updateS.setName_seller(seller.getName_seller());
             updateS.setLastname(seller.getLastname());
             updateS.setNit_seller(seller.getNit_seller());

             Seller update = repositorySeller.save(updateS);
             return ResponseEntity.ok(update);

         }
         else{
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
         }
     }

     public ResponseEntity<Seller>delete (long id){
         Optional<Seller> searchSeller = repositorySeller.findById(id);

         if (searchSeller.isPresent()){

           repositorySeller.deleteById(id);
             return ResponseEntity.ok(searchSeller.get());
         }
         else {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
         }
     }
}
