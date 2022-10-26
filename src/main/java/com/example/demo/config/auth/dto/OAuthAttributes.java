package com.example.demo.config.auth.dto;

import com.example.demo.src.users.user.model.User;
import com.example.demo.utils.JwtService;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;
    private String snsProvider;
    private String nickName;
    private String mobile;
    private LocalDateTime snsConnectedAt;
    private String snsIdx;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes,
                           String nameAttributeKey,
                           String name,
                           String email,
                           String picture,
                           String snsProvider,
                           String nickName,
                           String mobile,
                           LocalDateTime snsConnectedAt,
                           String snsIdx) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.snsProvider = snsProvider;
        this.nickName = nickName;
        this.mobile = mobile;
        this.snsConnectedAt = snsConnectedAt;
        this.snsIdx = snsIdx;
    }


    public static OAuthAttributes of(String registrationId,
                                     String userNameAttributeName,
                                     Map<String, Object> attributes){
        if(registrationId.equals("naver")){
            return ofNaver("id", attributes);
        }else if(registrationId.equals("kakao")){
            return ofKakao("id", attributes);
        }
        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>)attributes.get("response");
        return OAuthAttributes.builder()
                .name((String)response.get("name"))
                .nickName((String)response.get("nickName"))
                .mobile((String)response.get("mobile"))
                .picture((String)response.get("profile_image"))
                .email((String)response.get("email"))
                .nameAttributeKey(userNameAttributeName)
                .attributes(response)
                .snsConnectedAt(LocalDateTime.now())
                .snsIdx((String)response.get(userNameAttributeName))
                .snsProvider("네이버")
                .build();
    }
    private static OAuthAttributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> kakao_account = (Map<String, Object>)attributes.get("kakao_account");
        Map<String, Object> profile = (Map<String, Object>)kakao_account.get("profile");
        return OAuthAttributes.builder()
                .email((String)kakao_account.get("email"))
                .nickName((String)profile.get("nickname"))
                .picture((String)profile.get("profile_image_url"))
                .nameAttributeKey(userNameAttributeName)
                .attributes(attributes)
                .snsProvider("카카오")
                .snsIdx(String.valueOf(attributes.get("id")))
                .snsConnectedAt(LocalDateTime.now())
                .build();
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName,
                                            Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String)attributes.get("name"))
                .email((String)attributes.get("email"))
                .picture((String)attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .snsProvider("구글")
                .snsIdx((String)attributes.get(userNameAttributeName))
                .snsConnectedAt(LocalDateTime.now())
                .build();

    }

    public User toEntity(){
        return User.builder()
                .email(email)
                .profileImageUrl(picture)
                .nickName(nickName)
                .phone(mobile)
                .snsProvider(snsProvider)
                .snsIdx(snsIdx)
                .snsConnectedAt(snsConnectedAt)
                .status("ACTIVATED")
                .build();

    }
}
