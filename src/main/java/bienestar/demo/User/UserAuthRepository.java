package bienestar.demo.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthRepository extends JpaRepository<UserAuth, Integer>{
    Optional<UserAuth> findByUsername(String username);
}
