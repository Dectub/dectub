package com.dectub.iam.gateways.persistence;

import com.dectub.iam.domain.SystemRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/18 5:52 下午
 */
@Repository
public class SystemRepositoryImpl implements SystemRepository {
    private @Resource
    JpaSystemRepository jpaSystemRepository;

    @Override
    public String getConfig(String name) {
        return jpaSystemRepository.findByNameEquals(name).map(JpaSystem::toSystem).orElseThrow().value();
    }

    @Override
    public void save(String name, String value) {
        jpaSystemRepository.save(new JpaSystem(name, value));
    }
}
