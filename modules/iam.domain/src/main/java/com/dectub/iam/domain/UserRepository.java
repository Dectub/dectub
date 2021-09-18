package com.dectub.iam.domain;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/18 3:09 下午
 */
public interface UserRepository {
    User save(User user);
    User userForEmail(String email);
    void removeAll();
}
