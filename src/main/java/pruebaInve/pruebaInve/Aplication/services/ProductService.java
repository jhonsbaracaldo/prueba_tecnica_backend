package pruebaInve.pruebaInve.aplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pruebaInve.pruebaInve.domain.model.Product;
import pruebaInve.pruebaInve.domain.repository.RepositoryProduct;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private RepositoryProduct repositoryProduct;

     public List<Product>getAllProduct(){
         return this.repositoryProduct.findAll();
     }


     public Optional<Product> getAllProductId(Integer id){
         return this.repositoryProduct.findById(id);
     }

      public ResponseEntity<Product> newProduct (Product product){
           Product saveProduct = repositoryProduct.save(product);
          return new ResponseEntity<>(saveProduct, HttpStatus.CREATED);
      }

      public  ResponseEntity<Product> updateProduct ( Integer id,  Product product){
          Optional<Product> productExist = repositoryProduct.findById(id);

           if (productExist.isPresent()){
               Product existingProduct = productExist.get();
               existingProduct.setNameproduct(product.getNameproduct());
               existingProduct.setAmount(product.getAmount());
               existingProduct.setDescription(product.getDescription());
               existingProduct.setWeigth(product.getWeigth());
               existingProduct.setPrices(product.getPrices());
               Product updateProduct = repositoryProduct.save(existingProduct);
               return ResponseEntity.ok(updateProduct);
           }
           else{
                   return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
           }

      }





    public ResponseEntity<Product> deleteProduct (Integer id){
          Optional<Product> productExist = repositoryProduct.findById(id);

          if (productExist.isPresent()){
              repositoryProduct.deleteById(id);
              return ResponseEntity.ok(productExist.get());
            }else{
               return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
          }

      }


}
