package com.woc.gms.config;

import com.woc.gms.cons.USER_ROLE;
import com.woc.gms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/actuator/**",
                        "/v3/api-docs/**",
                        "/swagger-ui/**",
                        "**/swagger-ui.html",
                        "**/swagger-ui/index.html"
                        )
                .permitAll()
                .antMatchers(HttpMethod.POST, "/api/customer/**").hasAnyAuthority(USER_ROLE.ADMIN.name())
                .antMatchers(HttpMethod.GET, "/api/customer/**").hasAnyAuthority(USER_ROLE.ADMIN.name(), USER_ROLE.CUSTOMER.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()



                ;

    }
}
