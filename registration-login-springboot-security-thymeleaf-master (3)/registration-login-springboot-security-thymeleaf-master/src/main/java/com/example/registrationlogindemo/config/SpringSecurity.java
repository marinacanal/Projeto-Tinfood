package com.example.registrationlogindemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((authorize) ->
                        authorize.requestMatchers("/css/**", "/img/**", "/script/**").permitAll()
                                .requestMatchers("/registrar/**").permitAll()
                                .requestMatchers("/descricao").permitAll()
                                .requestMatchers("/descricao/**").permitAll()
                                .requestMatchers("/preferencia").permitAll()
                                .requestMatchers("/preferencia/**").permitAll()
                                .requestMatchers("/match/**").permitAll()
                                .requestMatchers("/editar/**").permitAll()
                                .requestMatchers("/categoria/**").permitAll()
                                .requestMatchers("/").permitAll()
                                .requestMatchers("/upload/**").permitAll()
                                .requestMatchers("/chat").permitAll()
                                .requestMatchers("/users").permitAll()
                                .requestMatchers("/api/**").permitAll()
                                
                ).formLogin(
                form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .permitAll()
                        .defaultSuccessUrl("/upload/perfil")
        ).logout(
                logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .permitAll()
        );
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}
