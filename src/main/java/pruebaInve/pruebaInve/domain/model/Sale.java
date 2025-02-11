package pruebaInve.pruebaInve.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
public class Sale {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private Integer id_seller;

   private Integer id_product;

   private Integer amount;

   private Double price;

   private BigDecimal total;

   private Date date;
}
