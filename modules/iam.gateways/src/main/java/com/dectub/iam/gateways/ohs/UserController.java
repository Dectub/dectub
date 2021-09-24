package com.dectub.iam.gateways.ohs;

import com.dectub.iam.application.ActiveUserUseCase;
import com.dectub.iam.application.RegisterUserUseCase;
import com.dectub.iam.application.UserInput;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/18 3:49 下午
 */
@RestController
@RequestMapping("/account")
public class UserController {
    private @Resource
    RegisterUserUseCase registerUserUseCase;
    private @Resource
    ActiveUserUseCase activeUserUseCase;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody UserInput input) {
        registerUserUseCase.execute(input);
    }

    @GetMapping("/active/{code}")
    public void active(@PathVariable String code) {
        activeUserUseCase.execute(code);
    }

}
