package com.test.security.testsecurity.config;

import com.test.security.testsecurity.authentication.MyAuthenctiationFailureHandler;
import com.test.security.testsecurity.authentication.MyAuthenticationSuccessHandler;
import com.test.security.testsecurity.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties properties;

    @Autowired
    private MyAuthenticationSuccessHandler successHandler;

    @Autowired
    private MyAuthenctiationFailureHandler failureHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/auth/require")
                .loginProcessingUrl("/user/login")
                .successHandler(successHandler)  //登陆成功处理
                .failureHandler(failureHandler)  //失败处理
                .and()
                .authorizeRequests()
                .antMatchers("/auth/require", properties.getBrowse().getLoginPage()).permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf()
                .disable();
    }
}
