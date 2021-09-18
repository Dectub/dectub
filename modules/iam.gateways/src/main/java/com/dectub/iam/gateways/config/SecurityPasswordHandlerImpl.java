package com.dectub.iam.gateways.config;

import com.dectub.iam.domain.SecurityPasswordHandler;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/18 4:00 下午
 */
@Component
public class SecurityPasswordHandlerImpl implements SecurityPasswordHandler {
    private @Resource PasswordEncoder bCryptPasswordEncoder;

    @Override
    public String encode(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    @Override
    public boolean verify(String password, String encodedPassword) {
        return bCryptPasswordEncoder.matches(password, encodedPassword);
    }
}
