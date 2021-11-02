package com.dectub.iam.gateways.config;

import com.dectub.frameworks.domain.core.GlobalIdentityService;
import com.dectub.iam.domain.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/18 5:38 下午
 */
@Component("newUserEmailConfirmOn")
public class NewUserEmailConfirmOnImpl implements NewUserEmailConfirm {

    private @Resource
    UserRepository userRepository;
    private @Resource
    SendRegisterEmailService sendRegisterEmailService;
    private @Resource
    CacheRepository cacheRepository;

    private static final String REGISTER_EMAIL = "register.email";

    @Override
    public void sendEmail(User user) {
        cacheRepository.save(REGISTER_EMAIL, Map.of(user.email(), String.valueOf(GlobalIdentityService.next())));
        sendRegisterEmailService.send(user.email());
        userRepository.save(user);
    }
}
