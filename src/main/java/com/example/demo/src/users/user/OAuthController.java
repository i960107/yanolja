package com.example.demo.src.users.user;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.users.user.model.PostOAuthUserRes;
import com.example.demo.src.users.user.model.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class OAuthController {
    private final UserRepository userRepository;
    private final OAuthProvider oAuthProvider;

    @GetMapping("/api/user/login/kakao")
    public BaseResponse<PostOAuthUserRes> authLoginWithKakao(@RequestParam(value = "accessToken", required = true) String accessToken) throws IOException {
        try {
            PostOAuthUserRes postUserRes = oAuthProvider.authLoginWithKakao(accessToken);
            return new BaseResponse<PostOAuthUserRes>(postUserRes);
        }catch(BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }


    @GetMapping("/api/user/login/naver")
    public BaseResponse<PostOAuthUserRes> authLoginWithNaver(@RequestParam(value = "accessToken", required = true) String accessToken) throws IOException {
        try {
            PostOAuthUserRes postUserRes = oAuthProvider.authLoginWithNaver(accessToken);
            return new BaseResponse<PostOAuthUserRes>(postUserRes);
        }catch(BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }
}
