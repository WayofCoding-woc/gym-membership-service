package com.woc.gms.config;

import com.woc.gms.cons.USER_ROLE;
import com.woc.gms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private UserService userService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder auth = http.getSharedObject(AuthenticationManagerBuilder.class);
        auth.userDetailsService(userService)
                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());
        AuthenticationManager authenticationManager = auth.build();

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/actuator/**",
                        "/v3/api-docs/**",
                        "/swagger-ui/**",
                        "**/swagger-ui.html",
                        "**/swagger-ui/index.html"//,
                        //"**"//enabling access to all api for fast ui dev temporarily
                        )
                .permitAll()
                .antMatchers(HttpMethod.POST, "/api/customer/**").hasAnyAuthority(USER_ROLE.ADMIN.name())
                .antMatchers(HttpMethod.GET, "/api/customer/**").hasAnyAuthority(USER_ROLE.ADMIN.name(), USER_ROLE.CUSTOMER.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .authenticationManager(authenticationManager)

                ;

        return http.build();
    }
}
