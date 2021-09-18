package com.dectub.frameworks.domain.core;

import lombok.Generated;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/18 3:25 下午
 */
public class SnowflakeIdentityService implements IdentityService {
    private static final SnowflakeIdGenerator DEFAULT = new SnowflakeIdGenerator(0, 0);

    @Override
    public long nextIdentity() {
        return DEFAULT.nextId();
    }

    public static class SnowflakeIdGenerator {
        private static final String WORK_ID_ERROR = "worker Id can't be greater than %d or less than 0";
        private static final String DATA_CENTER_ID_ERROR = "datacenter Id can't be greater than %d or less than 0";
        private static final String TIME_ERROR = "Clock moved backwards.  Refusing to generate id for %d milliseconds";

        private static final long TW_EPOCH = 1514649600000L;
        private static final long WORKER_ID_BITS = 5L;
        private static final long DATACENTER_ID_BITS = 5L;
        private static final long MAX_WORKER_ID = ~(-1L << WORKER_ID_BITS);
        private static final long MAX_DATACENTER_ID = ~(-1L << DATACENTER_ID_BITS);
        private static final long SEQUENCE_BITS = 12L;
        private static final long WORKER_ID_SHIFT = SEQUENCE_BITS;
        private static final long DATACENTER_ID_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS;
        private static final long TIMESTAMP_LEFT_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS + DATACENTER_ID_BITS;
        private static final long SEQUENCE_MASK = ~(-1L << SEQUENCE_BITS);
        private static long sequence = 0L;
        private static long lastTimestamp = -1L;

        private final long workerId;
        private final long datacenterId;

        public SnowflakeIdGenerator(long workerId, long datacenterId) {
            check(workerId, datacenterId);
            this.workerId = workerId;
            this.datacenterId = datacenterId;
        }

        @Generated
        public synchronized long nextId() {
            long timestamp = timeGen();
            check(timestamp);
            if (lastTimestamp == timestamp) {
                sequence = (sequence + 1) & SEQUENCE_MASK;
                if (sequence == 0) timestamp = tilNextMillis(lastTimestamp);
            } else sequence = 0L;
            lastTimestamp = timestamp;
            return generateNextId(timestamp);
        }

        @Generated
        private long generateNextId(long timestamp) {
            return ((timestamp - TW_EPOCH) << TIMESTAMP_LEFT_SHIFT) | (datacenterId << DATACENTER_ID_SHIFT)
                    | (workerId << WORKER_ID_SHIFT) | sequence;
        }

        @Generated
        private void check(long timestamp) {
            if (timestamp < lastTimestamp)
                throw new RuntimeException(String.format(TIME_ERROR, lastTimestamp - timestamp));
        }

        @Generated
        private void check(long workerId, long datacenterId) {
            if (workIdOutOfRange(workerId))
                throw new IllegalArgumentException(String.format(WORK_ID_ERROR, MAX_WORKER_ID));
            if (dataCenterIdOutOfRange(datacenterId))
                throw new IllegalArgumentException(String.format(DATA_CENTER_ID_ERROR, MAX_DATACENTER_ID));
        }

        @Generated
        private boolean dataCenterIdOutOfRange(long datacenterId) {
            return datacenterId > MAX_DATACENTER_ID || datacenterId < 0;
        }

        @Generated
        private boolean workIdOutOfRange(long workerId) {
            return workerId > MAX_WORKER_ID || workerId < 0;
        }

        @Generated
        protected long tilNextMillis(long lastTimestamp) {
            long timestamp = timeGen();
            while (timestamp <= lastTimestamp) timestamp = timeGen();
            return timestamp;
        }

        protected long timeGen() {
            return System.currentTimeMillis();
        }

    }
}
