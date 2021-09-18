package com.dectub.iam.gateways.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/18 4:15 下午
 */
@Configuration
public class BCryptPasswordEncoderBean {
    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
