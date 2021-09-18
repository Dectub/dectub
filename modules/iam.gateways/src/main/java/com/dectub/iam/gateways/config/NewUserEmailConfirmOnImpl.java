package com.dectub.iam.gateways.config;

import com.dectub.iam.domain.NewUserEmailConfirm;
import com.dectub.iam.domain.User;
import com.dectub.iam.domain.UserRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/18 5:38 下午
 */
@Component("newUserEmailConfirmOn")
public class NewUserEmailConfirmOnImpl implements NewUserEmailConfirm {
    private static final String ACTIVE = "active";

    private @Resource
    UserRepository userRepository;

    @Override
    public void sendEmail(User user) {
        user.setState(ACTIVE);
        userRepository.save(user);
    }
}
