    package bienestar.demo.Auth;

    import org.springframework.security.authentication.AuthenticationManager;
    import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.stereotype.Service;

    import bienestar.demo.Jwt.JwtService;
    import bienestar.demo.User.Role;
    import bienestar.demo.User.User;
    import bienestar.demo.User.UserRepository;
    import lombok.RequiredArgsConstructor;

    @Service
    @RequiredArgsConstructor
    public class AuthService {

        private final UserRepository userRepository;
        private final JwtService jwtService;
        private final PasswordEncoder passwordEncoder;
        private final AuthenticationManager authenticationManager;

        public AuthResponse login(LoginRequest request) {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
            // Autenticación correcta, generamos el token
            String token = jwtService.getToken(user);
            return AuthResponse.builder()
                    .token(token)
                    .build();

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
