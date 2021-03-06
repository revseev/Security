package spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import spring.security.LoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
/*
 // In-memory authentication
 @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // add UserBuilder
        UserBuilder users = User.withDefaultPasswordEncoder();
        // add users for in memory authentication
        auth.inMemoryAuthentication()
                .withUser(users.username("john").password("john").roles("EMPLOYEE"))
                .withUser(users.username("mary").password("mary").roles("EMPLOYEE", "MANAGER"))
                .withUser(users.username("roman").password("roman").roles("EMPLOYEE", "ADMIN"));
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").access("hasRole('USER') or hasRole('ADMIN')")
                .antMatchers("/list","/new","/save","delete","/edit").hasRole("ADMIN");

        http.formLogin()
                // указываем страницу с формой логина
                .loginPage("/login")
                //указываем логику обработки при логине
                .successHandler(new LoginSuccessHandler()) //NEW
                // указываем action с формы логина
                .loginProcessingUrl("/login") //No need to have a controller for this
                // Указываем параметры логина и пароля с формы логина
                .usernameParameter("username").passwordParameter("password")
                // даем доступ к форме логина всем
                .permitAll();

        http.logout()
                .permitAll();

        http.exceptionHandling()
                .accessDeniedPage("/access-denied");
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
