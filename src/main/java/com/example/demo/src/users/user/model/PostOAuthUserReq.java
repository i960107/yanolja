package com.example.demo.src.users.user.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostOAuthUserReq {
    private String email;
    private String profileImageUrl;
    private String snsProvider;
    private String snsIdx;
    private LocalDateTime snsConnectedAt;
    private String status;
    private String refreshToken;
    @Builder
    public PostOAuthUserReq(String email, String profileImageUrl, String snsProvider, String snsIdx, LocalDateTime snsConnectedAt,String refreshToken) {
        this.email = email;
        this.profileImageUrl = profileImageUrl;
        this.snsProvider = snsProvider;
        this.snsIdx = snsIdx;
        this.snsConnectedAt = snsConnectedAt;
        this.refreshToken = refreshToken;
        this.status = "ACTIVATED";
    }

    public User toEntity(){
        return User.builder()
                .email(email)
                .profileImageUrl(profileImageUrl)
                .snsProvider(snsProvider)
                .snsIdx(snsIdx)
                .snsConnectedAt(snsConnectedAt)
                .refreshToken(refreshToken)
                .status(status)
                .build();
    }
}
