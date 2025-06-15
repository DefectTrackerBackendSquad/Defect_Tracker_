// basic security settings,role-based access control and JWT (JSON Web Token)
// authentication, assuming you want to secure your REST API endpoints.
package com.defecttracker.config;

import com.defecttracker.filter.JWTAuthenticationFilter;
import com.defecttracker.filter.JWTAuthorizationFilter;
import com.defecttracker.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.authentication.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailsService customUserDetailsService;

    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/defects/**").hasAnyRole("ADMIN", "PROJECT_MANAGER", "TESTER")
                .antMatchers(HttpMethod.POST, "/api/defects").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/defects/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/defects/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/projects/**").hasAnyRole("ADMIN", "PROJECT_MANAGER")
                .antMatchers("/api/login", "/api/register").permitAll()  // Allow public access to login and register
                .anyRequest().authenticated()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))  // Add JWT filter for login
                .addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class); // Filter for token validation
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService) // Custom user details service
                .passwordEncoder(passwordEncoder()); // Password encoder
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // BCrypt for password hashing
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return customUserDetailsService;
    }
}
