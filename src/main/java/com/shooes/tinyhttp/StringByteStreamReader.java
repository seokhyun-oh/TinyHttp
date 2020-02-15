package com.shooes.tinyhttp;

import com.google.common.base.Strings;
import lombok.NonNull;

public class StringByteStreamReader extends AbstractByteStreamReader {

    private static final byte[] EMPTY_STREAM = new byte[0];

    private byte[] byteStream;

    private int cursor = 0;

    private StringByteStreamReader() {
    }

    private StringByteStreamReader(final String message) {
        super();
        byteStream = Strings.isNullOrEmpty(message)
                ? EMPTY_STREAM
                : message.getBytes();
        cursor = 0;
    }

    public static StringByteStreamReader from(final String message) {
        return new StringByteStreamReader(message);
    }

    @Override
    protected boolean fetchBytesInternal(@NonNull byte[] buffer) {
        int fetchSize = Math.min(byteStream.length - cursor, getFetchSize());

        System.arraycopy(byteStream, cursor, buffer, 0, fetchSize);

        cursor += fetchSize;

        return fetchSize < getFetchSize();
    }
}
