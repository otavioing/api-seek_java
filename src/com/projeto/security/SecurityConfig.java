package com.projeto.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.projeto.service.UsuarioService;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    private UsuarioService usuarioService;

    public SecurityConfig(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }    

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        String[] publicPaths = {
            "/css/**",
            "/js/**",
            "/img/**",
            "/view/**",
            "/api/**",
            "/",
            "/login",
            "/cadastrarusuario"
        };

        return http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(publicPaths).permitAll()
                .anyRequest().authenticated())
            .formLogin(form -> form
                .usernameParameter("email")
                .loginPage("/login").permitAll()
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/", true)
                .failureUrl("/login?error=true"))
            .logout(withDefaults())
            .userDetailsService(usuarioService)
            .build();
    }
}