package com.example.demo.src.users.user;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.users.user.model.*;
import com.example.demo.utils.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserProvider userProvider;
    private final JwtService jwtService;
    @Value("${server.domain}") private String domain;
    @Value("${server.port}")
    private String port;


    @GetMapping("/api")
    public String retrieveUser(Model model) {
        model.addAttribute("host", domain + ":" + port);
        return "index";
    }

    @GetMapping("/api/user/login/naver/callback")
    public String authLoginWithNaverCallback(Model model) {
        model.addAttribute("host", domain + ":" + port);
        return "index";
    }

    @ResponseBody
    @GetMapping("/api/user/token")
    public BaseResponse<GetAccessTokenRes> getAccessToken(@Valid @RequestBody GetAccessTokenReq getAccessTokenReq) {
        try {
            return new BaseResponse<GetAccessTokenRes>(
                    jwtService.refreshAccessToken(
                            getAccessTokenReq.getAccessToken(),
                            getAccessTokenReq.getRefreshToken()));
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/api/user/login")
    public BaseResponse<GetUserLoginRes> getUserLogin( @Valid @RequestBody GetUserLoginReq requestDto) {
        try {
            GetUserLoginRes responseDto = userProvider.getuserLogin(requestDto);
            return new BaseResponse<GetUserLoginRes>(responseDto);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @ResponseBody
    @PostMapping("/api/user")
    public BaseResponse<PostUserRes> postUserSignin(@RequestBody @Valid PostUserReq requestDto) {
        try {
            PostUserRes responseDto = userService.postUserSignin(requestDto);
            return new BaseResponse<PostUserRes>(responseDto);
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }

}
