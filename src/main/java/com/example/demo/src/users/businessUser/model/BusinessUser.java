package com.example.demo.src.users.businessUser.model;

import com.example.demo.config.BaseTimeEntity;
import com.example.demo.config.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "business_user")
public class BusinessUser extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String id;

    @Column
    private String password;

    @Column
    private String name;

    @Column(nullable = true)
    private String profileImageUrl;

    @Column(nullable = true)
    private String accommodationType;

    @Column(nullable = true)
    private Long accommodationIdx;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    @Builder
    public BusinessUser(Long idx,
                        String id,
                        String password,
                        String name,
                        String profileImageUrl,
                        String accommodationType,
                        Long accommodationIdx,
                        String phone,
                        String email,
                        Status status) {
        this.idx = idx;
        this.id = id;
        this.password = password;
        this.name = name;
        this.profileImageUrl = profileImageUrl;
        this.accommodationType = accommodationType;
        this.accommodationIdx = accommodationIdx;
        this.phone = phone;
        this.email = email;
        this.status = status;
    }

    public BusinessUser updateAccommodation(String accommodationType, Long accommodationIdx) {
        this.accommodationType = accommodationType;
        this.accommodationIdx = accommodationIdx;

        return this;
    }
}
