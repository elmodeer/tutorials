package com.keycloak.integration.keycloakbasicauth.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@Order(1)
public class BasicAuthSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Value("${spring.security.basic.matcher:/actuator/**}")
    String endpointMatcher;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable();
        http.requestMatchers().antMatchers(endpointMatcher.split(","))
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

}
