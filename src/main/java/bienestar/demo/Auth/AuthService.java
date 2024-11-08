package bienestar.demo.Auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import bienestar.demo.Jwt.JwtService;
import bienestar.demo.User.Role;
import bienestar.demo.User.UserAuth;
import bienestar.demo.User.UserAuthRepository;
import bienestar.demo.User.Admin;
import bienestar.demo.Exception.UserNotFoundException; // Importar la excepción personalizada
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserAuthRepository userAuthRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        UserAuth userAuth = userAuthRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));

        if (!userAuth.getRole().equals(Role.ADMIN)) {
            throw new RuntimeException("Acceso denegado. El usuario no es un ADMIN.");
        }

        String token = jwtService.getToken(userAuth);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        UserAuth userAuth = createAdminUserAuth(request);
        userAuthRepository.save(userAuth);
        String token = jwtService.getToken(userAuth);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    private UserAuth createAdminUserAuth(RegisterRequest request) {
        UserAuth userAuth = UserAuth.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ADMIN)
                .build();

        Admin admin = new Admin();
        admin.setUserAuth(userAuth);
        userAuth.setAdministrador(admin);

        return userAuth;
    }
}
