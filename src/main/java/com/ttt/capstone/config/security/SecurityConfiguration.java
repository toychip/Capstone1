package com.ttt.capstone.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http

                .csrf().disable()
                .cors().and()
                .authorizeHttpRequests()
                    .requestMatchers("/auth/signup").permitAll() // 누구나 접근 가능
                    .requestMatchers("/auth/signup-business").permitAll() // 누구나 접근 가능
                    .requestMatchers("/auth/login").permitAll() // 누구나 접근 가능
                    .requestMatchers("/").permitAll()
                    .requestMatchers("/css/**", "/js/**", "/images/**", "/favicon.ico").permitAll()
                    .requestMatchers("/region/**").permitAll()
//                    .requestMatchers(HttpMethod.POST, "/advertisement").hasAuthority("CEO") // CEO 권한일때만 POST 가능
                    .requestMatchers(HttpMethod.POST, "/review").hasAuthority("CEO") // CEO 권한일때만 POST 가능
//                    .requestMatchers("/review").permitAll()// USER 권한일때만 POST 가능
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOriginPattern("*"); // All origins are allowed, change this to your preferred origins
        config.addAllowedHeader("*"); // All headers are allowed, change this to your preferred headers
        config.addAllowedMethod("*"); // All methods are allowed, change this to your preferred methods
        ((UrlBasedCorsConfigurationSource) source).registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
