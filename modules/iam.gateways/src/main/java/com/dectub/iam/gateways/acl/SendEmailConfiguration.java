package com.dectub.iam.gateways.acl;

import com.dectub.iam.domain.SystemRepository;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.annotation.Resource;

import static com.dectub.frameworks.domain.core.SystemConfig.*;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/23 2:44 下午
 */
@Configuration
public class SendEmailConfiguration {

    private @Resource
    SystemRepository systemRepository;

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public SendEmailService sendEmailService() {
        return new SendEmailService(getConfig(REGISTER_EMAIL_HOST), getConfig(REGISTER_EMAIL_PORT),
                getConfig(REGISTER_EMAIL_USERNAME), getConfig(REGISTER_EMAIL_PASSWORD),
                getConfig(REGISTER_EMAIL_DEFAULT_ENCODING), getConfig(REGISTER_EMAIL_NAME));
    }

    private String getConfig(String configName) {
        return systemRepository.getConfig(configName);
    }

}
