package pruebaInve.pruebaInve.Aplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pruebaInve.pruebaInve.Aplication.services.SellerService;
import pruebaInve.pruebaInve.domain.model.Product;
import pruebaInve.pruebaInve.domain.model.Seller;

import java.util.List;
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
    public List<Seller> getSellerById(@PathVariable Long id) { // @PathVariable para extraer el ID
        return sellerService.sellerId(id);
    }

    @PostMapping ("/newSeller")
    public ResponseEntity<Seller> createSeller(@RequestBody Seller seller) { // @RequestBody para el JSON del cuerpo
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
