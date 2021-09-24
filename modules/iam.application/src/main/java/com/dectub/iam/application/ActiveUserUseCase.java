package com.dectub.iam.application;

import com.dectub.frameworks.application.core.UseCase;
import com.dectub.iam.domain.CacheRepository;
import com.dectub.iam.domain.User;
import com.dectub.iam.domain.UserRepository;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/24 11:46 上午
 */
@UseCase
public class ActiveUserUseCase {
    private final UserRepository userRepository;
    private final CacheRepository cacheRepository;

    private static final String REGISTER_EMAIL = "register.email";
    private static final String ACTIVE = "active";

    public ActiveUserUseCase(UserRepository userRepository, CacheRepository cacheRepository) {
        this.userRepository = userRepository;
        this.cacheRepository = cacheRepository;
    }

    public void execute(String code) {
        User user = userRepository.userForEmail(cacheRepository.getForValue(REGISTER_EMAIL, code));
        user.setState(ACTIVE);
        userRepository.save(user);
        cacheRepository.remove(REGISTER_EMAIL, user.email());
    }
}
