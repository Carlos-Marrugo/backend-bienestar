package bienestar.demo.Auth;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import bienestar.demo.User.Role;
import bienestar.demo.User.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public AuthResponse login(LoginRequest request) {
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

    }

}
