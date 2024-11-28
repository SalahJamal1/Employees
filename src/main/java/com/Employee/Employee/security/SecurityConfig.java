package com.Employee.Employee.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT username,pass,active FROM user WHERE username=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT username,role FROM auth a JOIN user u ON a.user_id=u.id WHERE u.username=?");
        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configure ->
                        configure.requestMatchers(HttpMethod.GET, "/api/employees/list").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.GET, "/api/employees/list/**").hasRole("EMPLOYEE")
                                .requestMatchers(HttpMethod.POST, "/api/employees/create").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.PATCH, "/api/employees/update").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.DELETE, "/api/employees/delete").hasRole("ADMIN"))
                .httpBasic(c -> c.disable()).httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }
}
