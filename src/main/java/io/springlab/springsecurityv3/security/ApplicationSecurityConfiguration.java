package io.springlab.springsecurityv3.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {


    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfiguration(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    //creating in memory user and encrypt the password
    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        //global student
        UserDetails commonUser= User.builder()
                                    .username("abcdf")
                                    .password(passwordEncoder.encode("12345"))
                                    .roles(UserRoles.STUDENT.name())
                                    .build();
        //admin
        UserDetails adminUser= User.builder()
                                    .username("admin")
                                    .password(passwordEncoder.encode("pass12345"))
                                    .roles(UserRoles.ADMIN.name())
                                    .build();
        //admin trainee
        UserDetails maxxUser= User.builder()
                                    .username("maxx")
                                    .password(passwordEncoder.encode("password"))
                                    .roles(UserRoles.ADMINTRINEE.name())
                                    .build();

        return new InMemoryUserDetailsManager(adminUser,commonUser,maxxUser);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /*//Basic Authentication<Different from Form authentication> drawback:we cant log out.
        //base 64 authentication is getting done;*/
        http.authorizeRequests()
                .antMatchers("/","index","/css/*","/js/*").permitAll()
                .antMatchers("/globalapi/**").hasRole(UserRoles.STUDENT.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }
}
