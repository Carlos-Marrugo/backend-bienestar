package bienestar.demo.Auth;

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

    public AuthResponse login(LoginRequest request) {
        // Implement login logic here
        return null;
    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .lastname(request.getLastname())
                .firstname(request.getFirstname())
                .country(request.getCountry())
                .password(request.getPassword())
                .role(Role.USER)
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
