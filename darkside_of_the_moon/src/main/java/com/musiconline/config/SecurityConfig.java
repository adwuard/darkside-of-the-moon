package com.musiconline.config;

import com.musiconline.service.MomPopUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public MomPopUserDetailsService momPopUserDetailsService;
    @Override
    public void configure(WebSecurity web) throws Exception {

        //  Ignore the resources
        web.ignoring().antMatchers("/css/**", "/images/**");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        // Require all requests to be authorized
        http.authorizeRequests()

                .antMatchers("/", "/about", "/careers").permitAll()
//                .antMatchers("/admin/**").authenticated()

                // add a login page
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("userpass")
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/logout-success")
                .permitAll()
        ;

        // turn off cross-site forgery
        http.headers().frameOptions().disable();
        http.csrf().disable();

    }

    /*
        This is our user/password
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("harambe")
//                .password("cincinnati")
//                .roles("USER");


        auth
                .userDetailsService(momPopUserDetailsService)
                .passwordEncoder(new PlaintextPasswordEncoder());

    }




}
