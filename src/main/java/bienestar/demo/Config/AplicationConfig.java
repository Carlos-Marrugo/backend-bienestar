package bienestar.demo.Config;

@Configuration
@RequiredArgsConstructor

public class AplicationConfig {

    private final UserRepository userRepository;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception
    {
        return config.getAuthenticationManager();
    }

    @Beanpublic AuthenticationProvider authenticationProvider()
    {
        DaoAuthenticationProvider authenticationProvider = new AuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    private UserDetailsService userDetailsService() {
        return username -> userRepository.findByUsername(username)
        .orElseThrow(() -> new UserNameNotFoundException("User Not Found"));
    }

}
