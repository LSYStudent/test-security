package com.test.security.testsecurity.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "security.lsy")
public class SecurityProperties {

    private BrowseProperties browse = new BrowseProperties();
}
