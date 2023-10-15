package sindhu.ecom.ecom_product_service.DTOs;


import lombok.Getter;
import lombok.Setter;
import sindhu.ecom.ecom_product_service.model.Product;

@Getter
@Setter
public class CreateProductRequestDto {
    
    private Product product;
    
    private String email;
    
    private String password;

}
