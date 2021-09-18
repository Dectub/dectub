package com.dectub.iam.application;

import com.dectub.frameworks.application.core.UseCase;
import com.dectub.frameworks.domain.core.GlobalIdentityService;
import com.dectub.iam.domain.SecurityPasswordHandler;
import com.dectub.iam.domain.User;
import com.dectub.iam.domain.UserRepository;

import java.time.Instant;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/18 4:21 下午
 */
@UseCase
public class RegisterUserUseCase {
    private final UserRepository userRepository;
    private final SecurityPasswordHandler securityPasswordHandler;

    private static final String BLOCKED = "new";

    public RegisterUserUseCase(UserRepository userRepository, SecurityPasswordHandler securityPasswordHandler) {
        this.userRepository = userRepository;
        this.securityPasswordHandler = securityPasswordHandler;
    }

    public void execute(UserInput userInput) {
        User user = userRepository.save(registerUser(userInput));
    }

    private User registerUser(UserInput userInput) {
        return new User(GlobalIdentityService.next(), userInput.name(), userInput.email(), userInput.roleIds(),
                BLOCKED, securityPasswordHandler.encode(userInput.password()), Instant.now(), Instant.now());
    }
}
