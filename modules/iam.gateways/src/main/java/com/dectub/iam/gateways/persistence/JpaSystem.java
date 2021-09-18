package com.dectub.iam.gateways.persistence;

import com.dectub.iam.domain.System;
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
 * @date 2021/9/18 5:49 下午
 */
@Entity
@Table(name = "dectub_system")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class JpaSystem {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private String value;

    public System toSystem() {
        return new System(name, value);
    }

}
