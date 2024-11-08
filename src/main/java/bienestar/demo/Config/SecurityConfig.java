package bienestar.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.http.SessionCreationPolicy;

import lombok.RequiredArgsConstructor;
import bienestar.demo.Jwt.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;  // Filtro de JWT
    private final AuthenticationProvider authenticationProvider;     // Provider de autenticación

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())  // Deshabilitar CSRF porque estamos usando JWT
                .authorizeRequests(authRequest -> authRequest
                        .requestMatchers("/auth/**").permitAll()  // Rutas de autenticación sin protección
                        .anyRequest().authenticated()  // Cualquier otra ruta requiere autenticación
                )
                .sessionManagement(sessionManager ->
                        sessionManager
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)  // Deshabilitar sesión
                )
                .authenticationProvider(authenticationProvider)  // Configurar el provider
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)  // Añadir el filtro JWT antes del filtro de autenticación de usuario y contraseña
                .build();
    }
}
