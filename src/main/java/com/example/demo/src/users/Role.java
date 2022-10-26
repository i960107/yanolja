package com.example.demo.src.users;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    USER("ROLE_USER", "일반 사용자"),
    BUSINESS_USER("ROLE_BUSINESS_USER","비지니스 사용자");

    private final String key;
    private final String title;

}
