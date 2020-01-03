package spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // add UserBuilder
        UserBuilder users = User.withDefaultPasswordEncoder();
        // add users for in memory authentication
        auth.inMemoryAuthentication()
                .withUser(users.username("john").password("john").roles("EMPLOYEE"))
                .withUser(users.username("mary").password("mary").roles("EMPLOYEE", "MANAGER"))
                .withUser(users.username("roman").password("roman").roles("EMPLOYEE", "ADMIN"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
//                .anyRequest().authenticated();
                .antMatchers("/").hasRole("EMPLOYEE")
                .antMatchers("/list").hasRole("ADMIN");

        http.formLogin()
                    .loginPage("/login") // TODO create a controller for this
                    .loginProcessingUrl("/authenticate") //No need to have a controller for this
                    .permitAll();

        http.logout()
                    .permitAll();

        http.exceptionHandling()
                .accessDeniedPage("/access-denied");
    }
}
