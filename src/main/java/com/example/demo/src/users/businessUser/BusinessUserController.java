package com.example.demo.src.users.businessUser;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.users.businessUser.model.*;
import io.sentry.Sentry;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/business-user")
public class BusinessUserController {
    private final BusinessUserProvider businessUserProvider;
    private final BusinessUserService businessUserService;

    @GetMapping("/{userIdx}")
    @ResponseBody
    public BaseResponse<GetBusinessUserRes> retrieveBusinessUser(@PathVariable("userIdx") Long userIdx) {
        try {

            return new BaseResponse<>(businessUserProvider.retrieveBusinessUser(userIdx));
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/login")
    @ResponseBody
    public BaseResponse<GetBusinessUserLoginRes> getBusinessUserLogin(@Valid @RequestBody GetBusinessUserLoginReq requestDto) {
        try {
            GetBusinessUserLoginRes responseDto = businessUserProvider.getBusinessUserLogin(requestDto);
            return new BaseResponse<>(responseDto);
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }

    @PostMapping("")
    @ResponseBody
    public BaseResponse<PostBusinessUserRes> postBusinessUser(@Valid @RequestBody PostBusinessUserReq requestDto) {
        try {
            PostBusinessUserRes responseDto = businessUserService.postBusinessUser(requestDto);
            return new BaseResponse<PostBusinessUserRes>(responseDto);
        } catch (BaseException e) {
            Sentry.captureException(e);
            return new BaseResponse<>(e.getStatus());
        }
    }
}
