package com.dectub.iam.gateways.persistence;

import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/18 3:47 下午
 */
public interface JpaUserRoleRepository extends Repository<JpaUserRole, Long> {
    void save(JpaUserRole jpaUserRole);
    List<JpaUserRole> findAllByUserIdEquals(Long userId);
    void deleteAll();
}
