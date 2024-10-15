package bienestar.demo.Auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import bienestar.demo.User.Role;
import bienestar.demo.User.User;
import bienestar.demo.User.UserRepository;
import bienestar.demo.Jwt.JwtService;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse login(LoginRequest request) {
        return null;
    }

    public AuthResponse register(RegisterRequest request) {
        // Hasheamos la contraseña antes de guardar el usuario
        User user = User.builder()
                .username(request.getUsername())
                .lastname(request.getLastname())
                .firstname(request.getFirstname())
                .country(request.getCountry())
                .password(passwordEncoder.encode(request.getPassword())) // Hasheamos la contraseña
                .role(Role.USER)
                .build();

        userRepository.save(user);
        

        // Retornamos la respuesta con el token J 
        return AuthResponse.builder()
                .token(jwtService.getToken(user))  
                .build();
    }
}
