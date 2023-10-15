package sindhu.ecom.ecom_product_service.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sindhu.ecom.ecom_product_service.DTOs.CreateProductRequestDto;
import sindhu.ecom.ecom_product_service.DTOs.GetProductDetailsRequestDto;
import sindhu.ecom.ecom_product_service.model.Product;
import sindhu.ecom.ecom_product_service.service.ProductService;

@RestController
public class ProductController {
    
    private ProductService productService;

    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }
    /*  -> GET locahost:8080/products/149 149 is product id 
           {
              email:
              password:
           }   
    */
    @GetMapping("/products/{productId}")
    Product getProductDetails(@PathVariable("productId") Long productId,
                              @RequestBody GetProductDetailsRequestDto request)
    {
    
     Product product = productService.getProductDetails(
        productId,
        request.getEmail(),
        request.getPassword()
     );
     return product;
    
    }
    
    /* --> POST localhost:8080/products
           {                   product: {
                                   title:
                                   desc:
                                   price:
                               } 
                               email:
                               password:
            }  */

    @PostMapping("/products") 
    Product createProduct(@RequestBody CreateProductRequestDto requestDto)
    {
    Product product1 = productService.createProduct(
        requestDto.getProduct(),
        requestDto.getEmail(),
        requestDto.getPassword()
    );
        return product1; 
    }
}
