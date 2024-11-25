package bienestar.demo.Auth;

import bienestar.demo.User.*;
import bienestar.demo.User.dto.StudentDTO;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import bienestar.demo.Jwt.JwtService;
import bienestar.demo.Exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserAuthRepository userAuthRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final StudentRepository studentRepository;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        // Obtener usuario
        UserAuth userAuth = userAuthRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));

        // Generar token
        String token = jwtService.getToken(userAuth);

        // Verificar rol y obtener estudiantes si es admin
        List<StudentDTO> students = null;
        if (userAuth.getRole() == Role.ADMIN) {
            students = studentRepository.findByCorreoEndingWith("@unicolombo.edu.co")
                    .stream()
                    .map(StudentDTO::new) // Convertir cada Student a StudentDTO
                    .collect(Collectors.toList());
        }

        // Build response
        return AuthResponse.builder()
                .token(token)
                .students(students) // Retornar la lista de DTOs
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        UserAuth userAuth = UserAuth.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.STUDENT)
                .build();

        userAuthRepository.save(userAuth);

        String token = jwtService.getToken(userAuth);
        return AuthResponse.builder().token(token).build();
    }

    public AuthResponse registerAdmin(RegisterRequest request) {
        UserAuth userAuth = UserAuth.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ADMIN)
                .build();

        Admin admin = new Admin();
        admin.setUserAuth(userAuth);
        userAuth.setAdministrador(admin);

        userAuthRepository.save(userAuth);

        String token = jwtService.getToken(userAuth);
        return AuthResponse.builder().token(token).build();
    }
}
