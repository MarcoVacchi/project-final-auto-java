package org.lessons.java.project_final_auto_java.security;

import org.springframework.security.config.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET, "/automobili/api/**").permitAll()
                        .requestMatchers("/automobili/create", "/automobili/edit/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/automobili/**").hasAuthority("ADMIN")
                        .requestMatchers("/optionals", "/optionals/**").hasAuthority("ADMIN")
                        .requestMatchers("/automobili", "/automobili/**").hasAnyAuthority("ADMIN")
                        .requestMatchers("/admin").hasAuthority("ADMIN")
                        .requestMatchers("/", "/**").permitAll())
                .formLogin(Customizer.withDefaults())
                .logout(Customizer.withDefaults())
                .exceptionHandling(Customizer.withDefaults())
                .cors(cors -> cors.disable())
                .csrf(csrf -> csrf.disable());

        return http.build();
    }

    @Bean
    @SuppressWarnings("deprecation")
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    DatabaseUserDetailService userDetailService() {
        return new DatabaseUserDetailService();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
