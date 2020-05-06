package com.test.security.testsecurity.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.security.testsecurity.properties.LoginType;
import com.test.security.testsecurity.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class MyAuthenctiationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties properties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        System.out.println("登陆失败！");
        if (LoginType.JSON.equals(properties.getBrowse().getLoginType())) {
            httpServletResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            httpServletResponse.getWriter().write(objectMapper.writeValueAsString(e));
        }else {
            super.onAuthenticationFailure(httpServletRequest, httpServletResponse, e);
        }

    }
}
