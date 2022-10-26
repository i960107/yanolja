package com.example.demo.src.users.user.model;

import com.example.demo.config.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = true, columnDefinition = "varchar(40)")
    private String id;

    @Column(name = "profileImageUrl",nullable = true, columnDefinition = "varchar(1000)" )
    private String profileImageUrl;

    @Column(nullable = true, columnDefinition = "varchar(600)")
    private String password;

    @Column(nullable = true, columnDefinition = "varchar(20)" )
    private String phone;

    @Column(nullable = true, columnDefinition = "varchar(45)")
    private String name;

    @Column(nullable = true, columnDefinition = "varchar(45)")
    private String email;

    @Column(name = "nickName", nullable = true, columnDefinition = "varchar(10)")
    private String nickName;

    @Column(nullable = true, length=(100))
    private String refreshToken;

    @Column(name = "snsProvider", nullable = true, length = (10))
    private String snsProvider;

    @Column(name = "snsConnectedAt", nullable = true, columnDefinition = "datetime")
    private LocalDateTime snsConnectedAt;

    @Column(name = "snsIdx", nullable = true, columnDefinition = "varchar(500)")
    private String snsIdx;

    @Column(nullable = false, columnDefinition = "varchar(10) default 'ACTIVATED'")
    private String status;

    @Builder
    public User(Long idx,
                String id,
                String profileImageUrl,
                String password,
                String phone,
                String name,
                String email,
                String nickName,
                String refreshToken,
                String snsProvider,
                LocalDateTime snsConnectedAt,
                String snsIdx,
                String status) {
        this.idx = idx;
        this.id = id;
        this.profileImageUrl = profileImageUrl;
        this.password = password;
        this.phone = phone;
        this.name = name;
        this.email = email;
        this.nickName = nickName;
        this.refreshToken = refreshToken;
        this.snsProvider = snsProvider;
        this.snsConnectedAt = snsConnectedAt;
        this.snsIdx = snsIdx;
        this.status = status;
    }


    public User update(String name, String picture, String email) {
        this.name = name;
        this.profileImageUrl = picture;
        this.email = email;
        return this;
    }

    public User updateOAuth(String email, String profileImageUrl, String snsProvider, String snsIdx, LocalDateTime snsConnectedAt){
        this.email = email;
        this.profileImageUrl = profileImageUrl;
        this.snsProvider = snsProvider;
        this.snsIdx = snsIdx;
        this.snsConnectedAt = snsConnectedAt;
        return this;
    }
}
