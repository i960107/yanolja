package com.example.demo.src.users.businessUser.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GetBusinessUserLoginRes {
    private Long idx;
    private String accessToken;
}
