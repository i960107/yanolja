package com.example.demo.src.users.user.model;

import lombok.Getter;

@Getter
public class GetAccessTokenRes {
    private String accessToken;

    public GetAccessTokenRes(String accessToken) {
        this.accessToken = accessToken;
    }
}
