package com.example.demo.src.users.businessUser.model;

import com.example.demo.utils.ValidationRegex;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
public class PostBusinessUserReq {
    @NotBlank
    @Pattern(regexp = ValidationRegex.regexId,message="숫자,영문자소문자,_ 1~10자리")
    private String id;
    @NotBlank
    @Pattern(regexp= ValidationRegex.regexPassword, message="숫자,영문자소문자,특수문자 8~12자")
    private String password;
    @NotBlank
    @Length(max=45)
    private String name;
    private String profileImageUrl;
    @NotBlank
    @Pattern(regexp = ValidationRegex.regexPhone,message = "숫자11자리")
    private String phone;
    @NotBlank
    @Email
    private String email;
    private String status = "ACTIVATED";
}
