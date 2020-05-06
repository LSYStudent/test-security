package com.test.security.testsecurity.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.security.testsecurity.properties.LoginType;
import com.test.security.testsecurity.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登陆成功
 */
@Configuration
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties properties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        System.out.println("登陆成功");
        if (LoginType.JSON.equals(properties.getBrowse().getLoginType())) {
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            httpServletResponse.getWriter().write(objectMapper.writeValueAsString(authentication));
        }else {
            super.onAuthenticationSuccess(httpServletRequest, httpServletResponse, authentication);
        }

    }
}
