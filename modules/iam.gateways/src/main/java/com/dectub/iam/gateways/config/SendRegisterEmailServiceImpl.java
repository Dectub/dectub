package com.dectub.iam.gateways.config;

import com.dectub.iam.domain.CacheRepository;
import com.dectub.iam.domain.SendRegisterEmailService;
import com.dectub.iam.domain.SystemRepository;
import com.dectub.iam.gateways.acl.GetWebsiteUrlService;
import com.dectub.iam.gateways.acl.SendEmailService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static com.dectub.frameworks.domain.core.SystemConfig.*;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/23 3:15 下午
 */
@Component
public class SendRegisterEmailServiceImpl implements SendRegisterEmailService {

    private @Resource
    BeanFactory beanFactory;
    private @Resource
    SystemRepository systemRepository;
    private @Resource
    CacheRepository cacheRepository;
    private @Resource
    GetWebsiteUrlService getWebsiteUrlService;

    private static final String PREFIX = "/account/active/";
    private static final String REGISTER_EMAIL = "register.email";

    private String createContent(String to) {
        return getConfig(REGISTER_EMAIL_CONTENT_PREFIX)
                .concat(getWebsiteUrlService.url()).concat(PREFIX).concat(cacheRepository.get(REGISTER_EMAIL, to))
                .concat(getConfig(REGISTER_EMAIL_CONTENT));
    }

    @Override
    public void send(String to) {
        beanFactory.getBean(SendEmailService.class).sendEmailTo(to, getConfig(REGISTER_EMAIL_TITLE),
                createContent(to));
    }

    private String getConfig(String name) {
        return systemRepository.getConfig(name);
    }

}
