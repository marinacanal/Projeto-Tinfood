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
                        authorize.requestMatchers("/css/**", "/imagens/**", "/img/**", "/fotos/**", "/script/**", "/resources/**").permitAll()
                                .requestMatchers("/registrar/**").permitAll()
                                .requestMatchers("/fotoPerfil/**").hasRole("ADMIN")
                                .requestMatchers("/descricao/**").hasRole("ADMIN")
                                .requestMatchers("/preferencia/**").hasRole("ADMIN")
                                .requestMatchers("/editar/**").hasRole("ADMIN")
                                .requestMatchers("/").permitAll()
                                .requestMatchers("/upload/**").hasRole("ADMIN")
                                .requestMatchers("/uploadArquivo/**").hasRole("ADMIN")
                                .requestMatchers("/downloadArquivo/**").hasRole("ADMIN")
                                .requestMatchers("/deletar/**").hasRole("ADMIN")
                                .requestMatchers("/api/**").permitAll()
                ).formLogin(
                form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .permitAll()
                        .defaultSuccessUrl("/descricao")
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
