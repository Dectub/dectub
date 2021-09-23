package com.dectub.iam.gateways.persistence;

import com.dectub.iam.domain.SystemRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/18 5:52 下午
 */
@Repository
public class SystemRepositoryImpl implements SystemRepository {
    private @Resource
    JpaSystemRepository jpaSystemRepository;

    private static final String REPLACE_PREFIX = "#%";
    private static final String REPLACE_SUFFIX = "&%";

    @Override
    public String getConfig(String name) {
        return getSubString(getValue(name));
    }

    private String getValue(String name) {
        return jpaSystemRepository.findByNameEquals(name).map(JpaSystem::toSystem).orElseThrow().value();
    }

    private String getSubString(String value) {
        if (!nameCanReplace(value)) return value;
        return getSubString(replaceReplacement(value, getSubConfig(value)));
    }

    private String getSubConfig(String value) {
        if (hasSubReplacement(removeFirstPrefix(value)))
            return value.substring(value.indexOf(REPLACE_PREFIX) + REPLACE_SUFFIX.length(),
                    value.indexOf(REPLACE_SUFFIX));
        return getSubConfig(removeFirstPrefix(value));
    }

    private String removeFirstPrefix(String value) {
        return value.substring(value.indexOf(REPLACE_PREFIX) + REPLACE_SUFFIX.length());
    }

    private boolean hasSubReplacement(String substring1) {
        return !containPrefix(substring1) || substring1.indexOf(REPLACE_PREFIX) > substring1.indexOf(REPLACE_SUFFIX);
    }

    private String replaceReplacement(String value, String substring) {
        if (jpaSystemRepository.existsByNameEquals(substring))
            return value.replaceFirst(regexString(substring), getValue(substring));
        else return value.replaceFirst(regexString(substring), substring);
    }

    private String regexString(String substring) {
        return REPLACE_PREFIX + substring + REPLACE_SUFFIX;
    }

    private boolean nameCanReplace(String value) {
        return containPrefix(value) && containSuffix(value);
    }

    private boolean containSuffix(String value) {
        return value.contains(REPLACE_SUFFIX);
    }

    private boolean containPrefix(String value) {
        return value.contains(REPLACE_PREFIX);
    }

    @Override
    public void save(String name, String value) {
        jpaSystemRepository.save(new JpaSystem(name, value));
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void remove(String name) {
        jpaSystemRepository.removeByNameEquals(name);
    }
}
