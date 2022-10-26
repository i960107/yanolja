package com.example.demo.src.users.businessUser.model;

import lombok.Getter;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class GetBusinessUserLoginReq {
   @NotBlank
   private String id;
   @NotBlank
   private String password;
}
