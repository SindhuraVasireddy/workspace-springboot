package sindhu.ecom.ecom_user_service.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sindhu.ecom.ecom_user_service.DTOs.SignUpUserRequestDto;
import sindhu.ecom.ecom_user_service.DTOs.VerifyUserRequestDto;
import sindhu.ecom.ecom_user_service.models.User;
import sindhu.ecom.ecom_user_service.service.UserService;

@RestController
public class UserController {
    
    private UserService userService;

    public UserController(UserService userService)
    {
       this.userService = userService; 
    }
@PostMapping("/users")
    public User signUp(@RequestBody SignUpUserRequestDto requestDto)
{
    return userService.signUp(requestDto.getEmail(), requestDto.getPassword());
}

//changing get to post for resttemplate easy.
//because it is easy to send body in post rather than in get
@PostMapping("/users/verify")
public boolean verifyUser(@RequestBody VerifyUserRequestDto requestDto)
{
    return userService.verifyUser(requestDto.getEmail(), requestDto.getPassword());
}
}