package io.springlab.springsecurityv3.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /*//Basic Authentication<Different from Form authentication> drawback:we cant log out.
        //base 64 authentication is getting done;
        http.authorizeRequests()
               .anyRequest()
               .authenticated()
               .and()
               .httpBasic();*/

        /*http.authorizeRequests()
                .antMatchers("/","index","/css/*","/js/*")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();*/



    }
}
