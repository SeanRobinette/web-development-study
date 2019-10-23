package com.seanrobinette.securitydemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // withDefaultPasswordEncoder is deprecated due to being insecure, but it's fine for demo apps
        User.UserBuilder user = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(user.username("susan").password("abc").roles("EMPLOYEE").build())
                .withUser(user.username("mary").password("123").roles("EMPLOYEE", "MANAGER").build())
                .withUser(user.username("sean").password("abc").roles("EMPLOYEE", "ADMIN").build());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.authorizeRequests()
                .antMatchers("/").hasRole("EMPLOYEE")
                .antMatchers("/leaders**").hasRole("MANAGER")
                .antMatchers("/admin**").hasRole("ADMIN")
                .antMatchers("/login*")
                    .permitAll()
                .and()
                .formLogin()
                    .loginPage("/showLoginPage")
                    .defaultSuccessUrl("/")
                    .successHandler(new SavedRequestAwareAuthenticationSuccessHandler())
                    .loginProcessingUrl("/login")
                    .permitAll()
                .and()
                .logout()
                    .permitAll()
        ;
    }
}
