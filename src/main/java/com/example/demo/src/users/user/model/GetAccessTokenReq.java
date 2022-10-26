package com.example.demo.src.users.user.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
public class GetAccessTokenReq {
    @NotBlank(message = "access Token을 입력")
    private String accessToken;
    @NotBlank(message = "refresh Token을 입력")
    private String refreshToken;

    public GetAccessTokenReq(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
