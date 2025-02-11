package pruebaInve.pruebaInve.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_product;

    private String nameproduct;

    private String description;

    private Integer amount;

    private Integer weigth;

    private double prices;

}

