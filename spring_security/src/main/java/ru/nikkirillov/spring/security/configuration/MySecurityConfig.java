package ru.nikkirillov.spring.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);


        // hardcoded логины, пароли, роли
        /*User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("nik").password("nik").roles("EMPLOYEE"));
        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("elena").password("elena").roles("HR"));
        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("ivan").password("ivan").roles("MANAGER","HR"));*/
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/").hasAnyRole("EMPLOYEE", "HR", "MANAGER")
                .antMatchers("/hrInfo").hasRole("HR")
                .antMatchers("/managerInfo/**").hasRole("MANAGER")
                .and().formLogin().permitAll(); // /** доступ ко всем url после /managerInfo
    }
}
