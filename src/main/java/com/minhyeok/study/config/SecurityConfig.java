package com.minhyeok.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // CSRF 보호 비활성화 (필요에 따라 활성화)
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/v1/member").permitAll()
                .requestMatchers(new AntPathRequestMatcher("/*.html")).permitAll() // 얘는 나중에 react 빌드하고 좀 봐야 함
                .anyRequest().authenticated())
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 토큰 쓸 거니까 session 비활성화
        );
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
            .requestMatchers("/*.css", "/*.js", "/public/**", "/*.html");
    }
}
