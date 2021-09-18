package com.dectub.iam.gateways.persistence;

import org.springframework.data.repository.Repository;

import java.util.Optional;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/18 3:15 下午
 */
public interface JpaUserRepository extends Repository<JpaUser, Long> {
    void save(JpaUser user);
    Optional<JpaUser> findByEmailEquals(String email);
    void deleteAll();
}
