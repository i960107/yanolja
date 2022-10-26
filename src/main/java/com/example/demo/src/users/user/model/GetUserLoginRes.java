package com.example.demo.src.users.user.model;

import lombok.Getter;

@Getter
public class GetUserLoginRes {
    private Long userIdx;
    private String accessToken;

    public GetUserLoginRes(Long userIdx, String accessToken) {
        this.userIdx = userIdx;
        this.accessToken = accessToken;
    }
}
