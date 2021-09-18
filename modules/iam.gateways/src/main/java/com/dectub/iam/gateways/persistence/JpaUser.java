package com.dectub.iam.gateways.persistence;

import com.dectub.iam.domain.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/18 3:17 下午
 */
@Entity
@Table(name = "dectub_user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JpaUser {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "state")
    private String state;

    @Column(name = "password")
    private String password;

    @Column(name = "create_time")
    private Instant createTime;

    @Column(name = "update_time")
    private Instant updateTime;

    public JpaUser(User user) {
        this.id = user.id();
        this.name = user.name();
        this.email = user.email();
        this.state = user.state();
        this.password = user.password();
        this.createTime = user.createTime();
        this.updateTime = user.updateTime();
    }

    public User toUser() {
        return new User(this.id, this.name, this.email, this.state, this.password, this.createTime, this.updateTime);
    }
}
