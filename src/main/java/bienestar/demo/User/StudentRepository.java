package bienestar.demo.User;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByCorreoEndingWith(String emailDomain);
}