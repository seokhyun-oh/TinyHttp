package com.shooes.tinyhttp;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;

import java.util.Objects;

public abstract class AbstractByteStreamReader {

    public static final int DEFAULT_FETCH_SIZE = 4096;

    @Getter(AccessLevel.PROTECTED)
    private int fetchSize = DEFAULT_FETCH_SIZE;

    public void setFetchSize(int fetchSize) {
        if (fetchSize <= 0) {
            throw new IllegalArgumentException("fetchSize is not positive");
        }
        this.fetchSize = fetchSize;
    }

    public boolean fetchBytes(byte[] buffer) {
        if (Objects.isNull(buffer) || buffer.length < fetchSize) {
            throw new IllegalArgumentException("buffer is null or has not enough size: " + fetchSize);
        }
        return fetchBytesInternal(buffer);
    }

    protected abstract boolean fetchBytesInternal(@NonNull byte[] buffer);
}
