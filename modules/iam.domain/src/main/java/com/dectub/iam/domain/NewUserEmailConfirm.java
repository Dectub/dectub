package com.dectub.iam.domain;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/18 5:37 下午
 */
public interface NewUserEmailConfirm {
    void sendEmail(User user);
}
