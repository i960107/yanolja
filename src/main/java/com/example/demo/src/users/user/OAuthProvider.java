package com.example.demo.src.users.user;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponseStatus;
import com.example.demo.src.users.Role;
import com.example.demo.src.users.user.model.PostOAuthUserReq;
import com.example.demo.src.users.user.model.PostOAuthUserRes;
import com.example.demo.src.users.user.model.User;
import com.example.demo.src.users.user.model.UserRepository;
import com.example.demo.utils.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;

@Service
@RequiredArgsConstructor
public class OAuthProvider {
    private final UserService userService;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public PostOAuthUserRes authLoginWithKakao(String accessToken) throws BaseException {

        ResponseEntity<HashMap> response;
        RestTemplate restTemplate = new RestTemplate();
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            headers.set("Authorization", "Bearer " + accessToken);
            HttpEntity request = new HttpEntity(headers);
            response = restTemplate.exchange("https://kapi.kakao.com/v2/user/me", HttpMethod.GET, request, HashMap.class);
        }catch (Exception exception ){
            throw new BaseException(BaseResponseStatus.OAUTH_LOGIN_ERROR);
        }

        if(response == null ) throw new BaseException(BaseResponseStatus.OAUTH_LOGIN_ERROR);

        String email = (String) ((LinkedHashMap) response.getBody().get("kakao_account")).get("email");
        String profileImageUrl = (String)((HashMap)((HashMap)response.getBody().get("kakao_account")).get("profile")).get("profile_image_url");
        String snsProvider = "kakao";
        String snsIdx = String.valueOf(response.getBody().get("id"));
        LocalDateTime snsConnectedAt = LocalDateTime.now();

        String refreshToken = jwtService.createJwtRefreshToken();

        PostOAuthUserReq postOAuthUserReq = new PostOAuthUserReq(email, profileImageUrl, snsProvider, snsIdx, snsConnectedAt,refreshToken);

        User user = userService.saveOAuthUser(postOAuthUserReq);

        return new PostOAuthUserRes(
                jwtService.createAccessToken(user.getIdx(), Role.USER.getKey()),
                user.getRefreshToken());
    }

    public PostOAuthUserRes authLoginWithNaver(String accessToken) throws BaseException{
        ResponseEntity<HashMap> response;
        RestTemplate restTemplate = new RestTemplate();
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            headers.set("Authorization", "Bearer " + accessToken);
            HttpEntity request = new HttpEntity(headers);
            response = restTemplate.exchange("https://openapi.naver.com/v1/nid/me", HttpMethod.GET, request, HashMap.class);
        }catch (Exception exception ){
            throw new BaseException(BaseResponseStatus.OAUTH_LOGIN_ERROR);
        }

        if(response == null) throw new BaseException(BaseResponseStatus.OAUTH_LOGIN_ERROR);

        String snsIdx = (String)((HashMap)response.getBody().get("response")).get("id");
        String email = (String)((HashMap)response.getBody().get("response")).get("email");
        String profileImageUrl  = (String)((HashMap)response.getBody().get("response")).get("profile_image");
        LocalDateTime snsConnectedAt = LocalDateTime.now();
        String snsProvider = "naver";

        String refreshToken = jwtService.createJwtRefreshToken();
        PostOAuthUserReq postOAuthUserReq = new PostOAuthUserReq(email,profileImageUrl,snsProvider,snsIdx,snsConnectedAt,refreshToken);
        System.out.println("여기");

        return new PostOAuthUserRes("",refreshToken);

    }
}
