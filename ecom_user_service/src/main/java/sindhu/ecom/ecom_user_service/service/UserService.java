package sindhu.ecom.ecom_user_service.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import sindhu.ecom.ecom_user_service.models.User;
import sindhu.ecom.ecom_user_service.repositories.UserRepository;

@Service
public class UserService {

private UserRepository userRepository;

public UserService(UserRepository userRepository)
{
    this.userRepository = userRepository;
}
public User signUp(String email, String password)
{
    User user = new User();
    user.setEmail(email);
    user.setPassword(password);

    User savedUser = userRepository.save(user);
    return savedUser;
}

public boolean verifyUser(String email, String password)
{
    Optional<User> user = userRepository.findByEmail(email);
    
    if(user.isEmpty())
    {
        return false;
    }

    User fetchedUser = user.get();
    if(!fetchedUser.getPassword().equals(password))
    {
        return false;
    }
    return true;
}

}

