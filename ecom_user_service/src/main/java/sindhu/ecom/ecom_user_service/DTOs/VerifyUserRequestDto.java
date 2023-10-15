package sindhu.ecom.ecom_user_service.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VerifyUserRequestDto {
    
    private String email;
    private String password;
}
