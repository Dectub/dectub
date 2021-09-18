package com.dectub.iam.gateways.persistence;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/18 3:47 下午
 */
@Entity
@Table(name = "dectub_user_role")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class JpaUserRole {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "role_id")
    private Long roleId;

    public Long getId() {
        return id;
    }

    public Long roleId() {
        return roleId;
    }
}
