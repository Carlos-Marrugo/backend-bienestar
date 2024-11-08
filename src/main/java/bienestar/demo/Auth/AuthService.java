    package bienestar.demo.Auth;

<<<<<<< HEAD
    import org.springframework.security.authentication.AuthenticationManager;
    import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.stereotype.Service;
=======
<<<<<<< Updated upstream
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import bienestar.demo.User.Role;
import bienestar.demo.User.User;
import bienestar.demo.User.UserRepository;
import bienestar.demo.Jwt.JwtService;
>>>>>>> feature/jwt-auth-registration

    import bienestar.demo.Jwt.JwtService;
    import bienestar.demo.User.Role;
    import bienestar.demo.User.User;
    import bienestar.demo.User.UserAuthRepository;
    import lombok.RequiredArgsConstructor;

    @Service
    @RequiredArgsConstructor
    public class AuthService {

        private final UserAuthRepository userRepository;
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
<<<<<<< HEAD
=======

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
=======
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import bienestar.demo.Jwt.JwtService;
import bienestar.demo.User.Role;
import bienestar.demo.User.UserAuth;
import bienestar.demo.User.UserAuthRepository;
import bienestar.demo.User.Admin; // Importa la entidad Admin
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserAuthRepository userAuthRepository; // Repositorio de UserAuth
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    // Método para login
    public AuthResponse login(LoginRequest request) {
        // Autenticación de usuario con el nombre de usuario y contraseña proporcionados
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        // Obtener el usuario autenticado desde el repositorio
        UserAuth userAuth = userAuthRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Verificamos que el rol sea ADMIN (solo para este caso)
        if (!userAuth.getRole().equals(Role.ADMIN)) {
            throw new RuntimeException("Acceso denegado. El usuario no es un ADMIN.");
        }

        // Generar token JWT para el usuario
        String token = jwtService.getToken(userAuth);

        // Devolver el token en la respuesta
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    // Método para registrar un nuevo usuario con rol ADMIN
    public AuthResponse register(RegisterRequest request) {
        // Crear un nuevo objeto UserAuth con los datos proporcionados y asignamos el rol de ADMIN
        UserAuth userAuth = UserAuth.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword())) // Hashear la contraseña
                .role(Role.ADMIN)  // El rol siempre será ADMIN para este caso
                .build();

        // Asociamos el usuario admin con la entidad Admin (relación OneToOne)
        Admin admin = new Admin();
        admin.setUserAuth(userAuth); // Asignamos el UserAuth al Admin
        userAuth.setAdministrador(admin); // Asignamos el Admin al UserAuth

        // Guardar el nuevo UserAuth en el repositorio
        userAuthRepository.save(userAuth);

        // Generar el token JWT para el nuevo usuario
        String token = jwtService.getToken(userAuth);

        // Devolver el token en la respuesta
        return AuthResponse.builder()
                .token(token)
>>>>>>> Stashed changes
                .build();
    }
}
>>>>>>> feature/jwt-auth-registration
