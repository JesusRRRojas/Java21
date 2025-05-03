package com.pe.proyecto.api_jersey.escuelaConductores.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



import static org.springframework.security.config.Customizer.withDefaults;
*/
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class SecuridadConfig {
	/*
	@Value("${seg.user.name}")
	private String username;

	@Value("${seg.user.password}")
	private String password;
	    
	@Bean
    public UserDetailsService userDetailsService() {
        // Definir un usuario en memoria con rol "USER"
        UserDetails user = User.builder()
                .username(username)
                .password(password)
                .roles("USER")  // Asegúrate de definir un rol
                .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF si no usas formularios
            .authorizeHttpRequests(auth -> auth
            		.requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                    .requestMatchers("/api/v1/**").authenticated() // Protege todas las rutas de API
                .anyRequest().permitAll() // Permite el resto sin autenticación
            )
            .httpBasic(withDefaults()); // Habilita autenticación Basic

        return http.build();
    }
    */
}
