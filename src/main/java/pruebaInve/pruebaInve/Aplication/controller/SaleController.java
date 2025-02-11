package pruebaInve.pruebaInve.Aplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pruebaInve.pruebaInve.Aplication.services.SaleService;
import pruebaInve.pruebaInve.domain.model.Product;
import pruebaInve.pruebaInve.domain.model.Sale;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping ("v1/sale")
public class SaleController {


    @Autowired
    private SaleService saleService;

    @GetMapping ("/all")
    public List<Sale> saleAll (){
        return saleService.searchSale();
    }

    @GetMapping("/{id}")
    public Optional<Sale> getSaleById(@PathVariable Integer id) {

        return saleService.searchSaleId(id);
    }

    @PostMapping ("/saveSale")
    public ResponseEntity<Sale> createSale(@RequestBody Sale sale) {
        return saleService.save(sale);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Sale> deleteSale(@PathVariable Integer id ) {
        return saleService.delete(id);
    }



}
