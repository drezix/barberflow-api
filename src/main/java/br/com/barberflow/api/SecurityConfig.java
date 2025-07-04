package br.com.barberflow.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(toH2Console()).permitAll() // Libera o H2 Console
                        .anyRequest().authenticated() // Exige autenticação para todo o resto
                )
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers(toH2Console()) // Desabilita proteção CSRF para o H2
                )
                .headers(headers -> headers
                        .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin) // Permite que o H2 seja exibido em um frame
                )
                .formLogin(form -> form.defaultSuccessUrl("/health", true)); // Mantém o formulário de login padrão

        return http.build();
    }
}