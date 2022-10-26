package com.example.demo.src.users.businessUser.model;

import com.example.demo.config.Status;
import lombok.Getter;

@Getter
public class GetBusinessUserRes {
    private Long idx;
    private String id;
    private String password;
    private String name;
    private String profileImageUrl;
    private String accommodationType;
    private Long accommodationIdx;
    private String phone;
    private String email;
    private Status status;

    public GetBusinessUserRes(BusinessUser entity) {
        this.idx = entity.getIdx();
        this.id = entity.getId();
        this.password = entity.getPassword();
        this.name = entity.getName();
        this.profileImageUrl = entity.getProfileImageUrl();
        this.accommodationType = entity.getAccommodationType();
        this.accommodationIdx = entity.getAccommodationIdx();
        this.phone = entity.getPhone();
        this.email = entity.getEmail();
        this.status = entity.getStatus();
    }
}
