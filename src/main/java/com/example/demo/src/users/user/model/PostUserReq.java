package com.example.demo.src.users.user.model;

import com.example.demo.utils.ValidationRegex;
import lombok.Getter;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
public class PostUserReq {
    @NotNull
    @Pattern(regexp = ValidationRegex.regexId)
    private String id;
    private String  profileImage;
    @NotNull
    @Pattern(regexp = ValidationRegex.regexPassword)
    private String password;
    @NotNull
    @Pattern(regexp = ValidationRegex.regexPhone)
    private String phone;
    @NotNull
    @Length(min = 1, max = 45)
    private String name;
    @NotNull
    @Email
    private String email;
    @NotNull
    @Pattern(regexp = ValidationRegex.regexNickName)
    private String nickName;

    public PostUserReq(String id, String profileImage, String password, String phone, String name, String email, String nickName) {
        this.id = id;
        this.profileImage = profileImage;
        this.password = password;
        this.phone = phone;
        this.name = name;
        this.email = email;
        this.nickName = nickName;
    }


}
