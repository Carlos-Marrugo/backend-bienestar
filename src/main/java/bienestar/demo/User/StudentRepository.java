package bienestar.demo.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Instructor, Integer> {
}
