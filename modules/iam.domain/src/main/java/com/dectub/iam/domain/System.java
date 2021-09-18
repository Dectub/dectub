package com.dectub.iam.domain;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/18 5:45 下午
 */
public class System {
    private final String name;
    private String value;

    public System(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String value() {
        return value;
    }
}
