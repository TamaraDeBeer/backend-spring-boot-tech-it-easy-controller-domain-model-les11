package com.example.backendspringboottechiteasycontrollerles10.configuration;

import com.example.backendspringboottechiteasycontrollerles10.filter.JwtRequestFilter;
import com.example.backendspringboottechiteasycontrollerles10.services.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    public final CustomUserDetailsService customUserDetailsService;
    public final JwtRequestFilter jwtRequestFilter;

    public SpringSecurityConfig(CustomUserDetailsService customUserDetailsService, JwtRequestFilter jwtRequestFilter) {
        this.customUserDetailsService = customUserDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
        var auth = new DaoAuthenticationProvider();
        auth.setPasswordEncoder(passwordEncoder);
        auth.setUserDetailsService(customUserDetailsService);
        return new ProviderManager(auth);
    }

    @Bean
    protected SecurityFilterChain filter(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers(HttpMethod.POST, "/users").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.GET, "/users").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.GET, "/users/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST, "/users/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/users/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST, "/cimodules").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/cimodules/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST, "/remotecontrollers").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/remotecontrollers/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST, "/televisions").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/televisions/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST, "/wallbrackets").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/wallbrackets/**").hasRole("ADMIN")
                                .requestMatchers("/cimodules", "/remotecontrollers", "/televisions", "/wallbrackets").hasAnyRole("ADMIN", "USER")
                                .requestMatchers("/cimodules/**", "/remotecontrollers/**", "/televisions/**", "/wallbrackets/**").hasAnyRole("ADMIN", "USER")
                                .requestMatchers("/authenticated").authenticated()
                                .requestMatchers("/authenticate").permitAll()
                                .anyRequest().denyAll()
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}

