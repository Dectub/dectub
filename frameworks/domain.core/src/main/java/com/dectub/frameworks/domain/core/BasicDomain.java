package com.dectub.frameworks.domain.core;

import lombok.Getter;

import java.time.Instant;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/18 3:00 下午
 */
@Getter
public class BasicDomain {
    private final Instant createTime;
    private Instant updateTime;

    public BasicDomain(Instant createTime, Instant updateTime) {
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public void updateUpdateTime(Instant time) {
        this.updateTime = time;
    }

    public void updateUpdateTime() {
        this.updateTime = Instant.now();
    }

}
