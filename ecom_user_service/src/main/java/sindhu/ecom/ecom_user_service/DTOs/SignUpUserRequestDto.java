package sindhu.ecom.ecom_user_service.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpUserRequestDto {
    private String email;
    private String password;
}
//Difference between SignUp User DTO and Verify User DTO
//In future signup user may have to add phonenumber and other details
//but verify user only need email and password