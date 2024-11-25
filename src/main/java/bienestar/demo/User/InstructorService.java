package bienestar.demo.User;

import bienestar.demo.User.dto.InstructorRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InstructorService {

    private final UserAuthRepository userAuthRepository;
    private final InstructorRepository instructorRepository;
    private final PasswordEncoder passwordEncoder;

    public Instructor registerInstructor(InstructorRequest request) {
        // Verificar si el username ya existe
        if (userAuthRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("El nombre de usuario ya está en uso");
        }

        // Crear registro en UserAuth
        UserAuth userAuth = UserAuth.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.INSTRUCTOR)
                .build();

        userAuthRepository.save(userAuth);

        // Crear registro en Instructor
        Instructor instructor = Instructor.builder()
                .areaEspecializacion(request.getAreaEspecializacion())
                .horarioAsignado(request.getHorarioAsignado())
                .userAuth(userAuth)
                .build();

        return instructorRepository.save(instructor);
    }
}