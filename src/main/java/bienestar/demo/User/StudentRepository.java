package bienestar.demo.User;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByCorreoEndingWith(String emailDomain);
    Optional<Student> findByCedula(String cedula);
}
