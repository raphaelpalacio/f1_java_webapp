package com.f1analysis.config;

// TODO: Uncomment these imports when Spring Security is enabled in pom.xml
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

/**
 * Spring Security configuration.
 * 
 * TODO: Enable this when ready to add authentication
 * 1. Uncomment Spring Security dependency in pom.xml
 * 2. Uncomment the annotations and imports above
 * 3. Implement the security configuration below
 */
// @Configuration
// @EnableWebSecurity
public class SecurityConfig {

    /**
     * Configure security filter chain.
     * 
     * TODO: Implement security rules
     * - Public pages: /, /login, /register
     * - Protected pages: /dashboard, /predictions, /profile
     * - Admin pages: /admin/**
     */
    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //     http
    //         .authorizeHttpRequests(auth -> auth
    //             // Public endpoints
    //             .requestMatchers("/", "/login", "/register").permitAll()
    //             .requestMatchers("/drivers", "/races", "/circuits").permitAll()
    //             
    //             // Protected endpoints
    //             .requestMatchers("/dashboard", "/predictions/**", "/profile").authenticated()
    //             
    //             // Admin only
    //             .requestMatchers("/admin/**").hasRole("ADMIN")
    //             
    //             // Everything else requires auth
    //             .anyRequest().authenticated()
    //         )
    //         .formLogin(form -> form
    //             .loginPage("/login")
    //             .defaultSuccessUrl("/dashboard")
    //             .permitAll()
    //         )
    //         .logout(logout -> logout
    //             .logoutSuccessUrl("/")
    //             .permitAll()
    //         );
    //     
    //     return http.build();
    // }

    /**
     * Password encoder bean.
     * 
     * TODO: Enable when Spring Security is active
     */
    // @Bean
    // public PasswordEncoder passwordEncoder() {
    //     return new BCryptPasswordEncoder();
    // }
}

