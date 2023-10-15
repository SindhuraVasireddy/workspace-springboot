package sindhu.ecom.ecom_product_service.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserServiceVerifyUserRequestDto {
    
    String email;

    String password;
}
