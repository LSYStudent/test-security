package com.test.security.testsecurity.properties;

import lombok.Data;

@Data
public class BrowseProperties {

    private String loginPage = "/login.html";

    private LoginType loginType = LoginType.JSON;
}
