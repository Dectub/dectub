package com.dectub.iam.gateways.persistence;

import org.springframework.data.repository.Repository;

import java.util.Optional;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/18 5:50 下午
 */
public interface JpaSystemRepository extends Repository<JpaSystem, Long> {
    Optional<JpaSystem> findByNameEquals(String name);
    void save(JpaSystem jpaSystem);
    boolean existsByNameEquals(String name);
    void removeByNameEquals(String name);
}
