package com.dectub.iam.gateways.config;

import com.dectub.iam.domain.SendRegisterEmailService;
import com.dectub.iam.gateways.acl.SendEmailService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/23 3:15 下午
 */
@Component
public class SendRegisterEmailServiceImpl implements SendRegisterEmailService {

    private @Resource
    BeanFactory beanFactory;

    private static final String TITLE = "Confirm your account now";
    private static final String CONTENT = "<h1>Welcome to our family!</h1>"
            .concat("<h2>Click the button below to confirm email identity.</h2>")
            .concat("<h3>Warning: Please ignore this email unless you do it yourself</h3>")
            .concat("<button type=\"button\">Verify</button>");

    @Override
    public void send(String to) {
        beanFactory.getBean(SendEmailService.class).sendEmailTo(to, TITLE, CONTENT);
    }

}
