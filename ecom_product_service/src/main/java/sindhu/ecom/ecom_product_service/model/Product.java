package sindhu.ecom.ecom_product_service.model;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity

@Getter

@Setter

public class Product {
    
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        

        private String title;
        private String description;
        private double price;
        private Date createdAt;
        private Date lastModifiedAt;
        private int remainingQuantity;
    }

