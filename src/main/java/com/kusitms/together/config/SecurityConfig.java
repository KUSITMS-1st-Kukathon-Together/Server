package com.kusitms.together.config;

import com.kusitms.together.filter.JwtRequestFilter;
import com.kusitms.together.filter.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtUtil jwtutil;

    private final AuthenticationManager authenticationManager;

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {

        return web -> {
            web.ignoring().antMatchers(
                    "/health",
                    "/swagger-ui.html",
                    "/h2-console/**",
                    "/api/auth/token",
                    "/near"
            );
        };

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
//                .cors(AbstractHttpConfigurer::disable)
                .formLogin().disable()
                .authorizeRequests()
                .antMatchers("/api/auth/sign-up", "/api/auth/login").permitAll()
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .headers().frameOptions().disable()
                .cacheControl().disable()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(new JwtRequestFilter(jwtutil, authenticationManager), UsernamePasswordAuthenticationFilter.class)
//                .addFilterBefore(new ExceptionHandlerFilter(), JwtRequestFilter.class)
        ;

        return http.build();

    }

}
