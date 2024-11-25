package bienestar.demo.User;

import bienestar.demo.User.dto.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Método para obtener todos los estudiantes y convertirlos a DTOs
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(StudentDTO::new)  // Convertir cada Student a StudentDTO
                .collect(Collectors.toList());
    }
}
