package com.shooes.tinyhttp;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HttpRequestDecoder {

    @NonNull
    private AbstractByteStreamReader reader;

}
