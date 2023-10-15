package sindhu.ecom.ecom_product_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sindhu.ecom.ecom_product_service.model.Product;
import java.util.Optional;



public interface ProductRepository

extends JpaRepository<Product, Long> {
    
Product save(Product product);
//telling the database to save the Product product without having product ID and asking 
//to return the product which also have product ID

@Override
Optional<Product> findById(Long aLong);
//telling the database to get the saved row details by using productID
}
