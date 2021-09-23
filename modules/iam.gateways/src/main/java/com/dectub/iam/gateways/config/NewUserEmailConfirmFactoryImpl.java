package com.dectub.iam.gateways.config;

import com.dectub.iam.domain.NewUserEmailConfirm;
import com.dectub.iam.domain.NewUserEmailConfirmFactory;
import com.dectub.iam.domain.SystemRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static com.dectub.frameworks.domain.core.SystemConfig.REGISTER_EMAIL;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/18 5:43 下午
 */
@Component
public class NewUserEmailConfirmFactoryImpl implements NewUserEmailConfirmFactory {
    private @Resource
    SystemRepository systemRepository;
    private @Resource
    NewUserEmailConfirm newUserEmailConfirmOff;
    private @Resource
    NewUserEmailConfirm newUserEmailConfirmOn;

    @Override
    public NewUserEmailConfirm create() {
        if ("off".equals(systemRepository.getConfig(REGISTER_EMAIL)))
            return newUserEmailConfirmOff;
        else return newUserEmailConfirmOn;
    }
}
