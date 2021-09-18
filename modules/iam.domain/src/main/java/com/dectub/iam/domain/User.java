package com.dectub.iam.domain;

import com.dectub.frameworks.domain.core.BasicDomain;

import java.time.Instant;
import java.util.Set;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/18 2:57 下午
 */
public class User extends BasicDomain {
    private final long id;
    private final String name;
    private final String email;
    private Set<Long> roleIds;
    private String state;
    private final String password;

    public User(long id, String name, String email, Set<Long> roleIds, String state, String password,
                Instant createTime, Instant updateTime) {
        super(createTime, updateTime);
        this.id = id;
        this.name = name;
        this.email = email;
        this.roleIds = roleIds;
        this.state = state;
        this.password = password;
    }

    public User(long id, String name, String email, String state, String password, Instant createTime,
                Instant updateTime) {
        super(createTime, updateTime);
        this.id = id;
        this.name = name;
        this.email = email;
        this.state = state;
        this.password = password;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void resetRoleIds(Set<Long> roleIds) {
        this.roleIds = roleIds;
    }

    public long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String email() {
        return email;
    }

    public Set<Long> roleIds() {
        return roleIds;
    }

    public String state() {
        return state;
    }

    public String password() {
        return password;
    }

    public Instant createTime() {
        return super.getCreateTime();
    }

    public Instant updateTime() {
        return super.getUpdateTime();
    }
}
