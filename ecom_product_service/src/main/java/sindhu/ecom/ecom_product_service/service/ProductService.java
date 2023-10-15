package sindhu.ecom.ecom_product_service.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import sindhu.ecom.ecom_product_service.DTOs.UserServiceVerifyUserRequestDto;
import sindhu.ecom.ecom_product_service.model.Product;
import sindhu.ecom.ecom_product_service.repositories.ProductRepository;
import java.util.Optional;
@Service
public class ProductService {
    private ProductRepository productRepository;
    
    private RestTemplateBuilder restTemplateBuilder;

    public ProductService(ProductRepository productRepository, RestTemplateBuilder restTemplateBuilder)
    {
      this.productRepository = productRepository;
      this.restTemplateBuilder = restTemplateBuilder;

    //whenever I have to sent request to another service,
    //there I will use restTemplate.RESTTEMPLATEBuilder that can be
    //used to configure and create a RestTemplate 
    }
    private boolean authenticate(String email, String password){
      
      
      //here the response from user service is coming as false
      //or true , so response entity must be a boolean type
      
      UserServiceVerifyUserRequestDto dto = new UserServiceVerifyUserRequestDto();
      dto.setEmail(email);
      dto.setPassword(password);
      
      RestTemplate restTemplate = restTemplateBuilder.build();
      ResponseEntity<Boolean> response = restTemplate.postForEntity(
        "http://localhost:8080/users/verify",
        dto,
        Boolean.class);
        //grey are automatic words given by vscodes
        //responseType we are specifying boolean means
        //we are asking whatever response object we are getting, it need to convert into boolean type.
        //DTO means we are sending the email and password in object format.

      boolean answer = response.getBody();
      return answer;
    }
    public Product getProductDetails(Long productId,
                      String email,
                      String password)
                      {

                        if(!authenticate(email, password))
                        {
                          return null;
                        }
                        Optional<Product> product = productRepository.findById(productId);
                        return product.get();
                      }
                      
    public Product createProduct(Product product,
                      String email,
                      String password)
                      {
                      if(!authenticate(email, password))
                        {
                          return null;
                        }
                        
                      Product savedProduct = productRepository.save(product);
                        return savedProduct; 
                      }                  
}
