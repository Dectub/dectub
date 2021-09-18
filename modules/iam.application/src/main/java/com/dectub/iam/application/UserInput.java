package com.dectub.iam.application;

import java.util.Set;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/18 3:53 下午
 */
public class UserInput {
    private final String name;
    private final String email;
    private final Set<Long> roleIds;
    private final String password;

    public UserInput(String name, String email, Set<Long> roleIds, String password) {
        this.name = name;
        this.email = email;
        this.roleIds = roleIds;
        this.password = password;
    }

    public String name() {
        return name;
    }

    public String email() {
        return email;
    }

    public Set<Long> roleIds() {
        return roleIds;
    }

    public String password() {
        return password;
    }
}
