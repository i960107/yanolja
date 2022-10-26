package com.example.demo.src.users.user.model;

import lombok.Getter;

import javax.validation.constraints.NotNull;
@Getter
public class GetUserLoginReq {
    @NotNull
    private String idOrEmail;
    @NotNull
    private String password;
}
