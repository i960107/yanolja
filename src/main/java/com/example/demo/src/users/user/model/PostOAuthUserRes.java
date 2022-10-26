package com.example.demo.src.users.user.model;

import lombok.*;

@Getter
public class PostOAuthUserRes {
    String accessToken;
    String refreshToken;

    @Builder
    public PostOAuthUserRes(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
