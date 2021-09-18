package com.dectub.iam.application;

import com.dectub.frameworks.application.core.UseCase;
import com.dectub.frameworks.domain.core.GlobalIdentityService;
import com.dectub.iam.domain.*;

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
    private final NewUserEmailConfirmFactory newUserEmailConfirmFactory;

    private static final String BLOCKED = "new";

    public RegisterUserUseCase(UserRepository userRepository, SecurityPasswordHandler securityPasswordHandler,
                               NewUserEmailConfirmFactory newUserEmailConfirmFactory) {
        this.userRepository = userRepository;
        this.securityPasswordHandler = securityPasswordHandler;
        this.newUserEmailConfirmFactory = newUserEmailConfirmFactory;
    }

    public void execute(UserInput userInput) {
        User user = userRepository.save(registerUser(userInput));
        newUserEmailConfirmFactory.create().sendEmail(user);
    }

    private User registerUser(UserInput userInput) {
        return new User(GlobalIdentityService.next(), userInput.name(), userInput.email(), userInput.roleIds(),
                BLOCKED, securityPasswordHandler.encode(userInput.password()), Instant.now(), Instant.now());
    }
}
