package com.ttt.capstone.response;

import lombok.Getter;

@Getter
public class SessionResponse {
    private final String accessToken;

    public SessionResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
