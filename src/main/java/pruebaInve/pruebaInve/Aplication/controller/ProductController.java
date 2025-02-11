package pruebaInve.pruebaInve.aplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pruebaInve.pruebaInve.domain.model.Product;
import pruebaInve.pruebaInve.aplication.services.ProductService;


import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping ("v1/product")
public class ProductController {

  @Autowired
    private ProductService productService;

  @GetMapping ("/all")
   public List<Product> productAll (){
      return  productService.getAllProduct();
  }

    @GetMapping("/{id}")
     public Optional<Product> SearchProductId (@PathVariable("id") Integer id){
         return productService.getAllProductId(id);
       }

     @PostMapping (path = "/saveProduct")
       public ResponseEntity<Product> saveProduct (@RequestBody Product product){
             return productService.newProduct(product);
       }
    @PutMapping("/{id}")
       public ResponseEntity<Product> updateProduct (@RequestBody Product product, @PathVariable Integer id){
       return productService.updateProduct(id, product);
       }


    @DeleteMapping("/{id}")
       public  ResponseEntity<Product> deleteProduct (@PathVariable Integer id){
      return  productService.deleteProduct(id);
       }



}
