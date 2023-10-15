package sindhu.ecom.ecom_user_service.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sindhu.ecom.ecom_user_service.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    User save(User user);

    Optional<User> findByEmail(String email);
}
