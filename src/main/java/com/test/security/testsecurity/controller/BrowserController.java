package com.test.security.testsecurity.controller;

import com.test.security.testsecurity.properties.SecurityProperties;
import com.test.security.testsecurity.support.SimpleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/auth")
public class BrowserController {

    private RequestCache cache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    private SecurityProperties properties;

    @RequestMapping(value = "/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public SimpleResponse requireAuth(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SavedRequest savedRequest = cache.getRequest(request,response);
        if (null != savedRequest) {
            String target = savedRequest.getRedirectUrl();
            if (StringUtils.endsWithIgnoreCase(target, ".html")) {
                redirectStrategy.sendRedirect(request, response, properties.getBrowse().getLoginPage());
            }
        }
        return new SimpleResponse("访问的服务需要身份验证信息，请引导用户到登陆页");
    }
}
