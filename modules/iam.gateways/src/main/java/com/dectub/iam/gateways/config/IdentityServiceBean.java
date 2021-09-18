package com.dectub.iam.gateways.config;

import com.dectub.frameworks.domain.core.GlobalIdentityService;
import com.dectub.frameworks.domain.core.IdentityService;
import com.dectub.frameworks.domain.core.SnowflakeIdentityService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IdentityServiceBean {
    @Bean
    public IdentityService identityService() {
        var snowflakeIdentityService = new SnowflakeIdentityService();
        GlobalIdentityService.reset(snowflakeIdentityService);
        return snowflakeIdentityService;
    }
}
