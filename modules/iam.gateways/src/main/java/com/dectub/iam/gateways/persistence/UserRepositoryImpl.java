package com.dectub.iam.gateways.persistence;

import com.dectub.frameworks.domain.core.GlobalIdentityService;
import com.dectub.iam.domain.User;
import com.dectub.iam.domain.UserRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/18 4:10 下午
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    private @Resource
    JpaUserRepository jpaUserRepository;
    private @Resource
    JpaUserRoleRepository jpaUserRoleRepository;

    @Override
    @Transactional
    public User save(User user) {
        jpaUserRepository.save(new JpaUser(user));
        user.roleIds().forEach(o ->
                jpaUserRoleRepository.save(new JpaUserRole(GlobalIdentityService.next(), user.id(), o)));
        return user;
    }

    @Override
    public User userForEmail(String email) {
        User user = jpaUserRepository.findByEmailEquals(email).map(JpaUser::toUser).orElseThrow();
        user.resetRoleIds(getRoleIds(user));
        return user;
    }

    @Override
    @Transactional(rollbackOn = {Exception.class})
    public void removeAll() {
        jpaUserRepository.deleteAll();
        jpaUserRoleRepository.deleteAll();
    }

    private Set<Long> getRoleIds(User user) {
        List<JpaUserRole> byUserIdEquals = jpaUserRoleRepository.findAllByUserIdEquals(user.id());
        return byUserIdEquals.stream()
                .map(JpaUserRole::roleId).collect(Collectors.toSet());
    }
}
