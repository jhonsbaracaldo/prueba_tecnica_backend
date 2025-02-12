package pruebaInve.pruebaInve.aplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pruebaInve.pruebaInve.aplication.services.SellerService;
import pruebaInve.pruebaInve.domain.model.Seller;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping ("v1/seller")
@RestController
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @GetMapping ("/all")
    public List<Seller> sellerAll (){
        return  sellerService.sellerAll();
    }

    @GetMapping("/{id}")
    public Optional<Seller> getSellerById(@PathVariable Long id) {
        return sellerService.sellerId(id);
    }

    @PostMapping ("/newSeller")
    public ResponseEntity<Seller> createSeller(@RequestBody Seller seller) { 
        return sellerService.save(seller);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seller> updateSeller(@PathVariable Long id, @RequestBody Seller seller) {
        return sellerService.update(id, seller);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Seller> deleteSeller(@PathVariable Long id) { // @PathVariable
        return sellerService.delete(id);
    }

    @GetMapping
    public List<Seller> getAllSellers() {
        return null;
    }
}
