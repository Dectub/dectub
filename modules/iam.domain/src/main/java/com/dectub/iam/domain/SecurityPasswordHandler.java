package com.dectub.iam.domain;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/18 3:59 下午
 */
public interface SecurityPasswordHandler {
    String encode(String password);
    boolean verify(String password, String encodedPassword);
}
