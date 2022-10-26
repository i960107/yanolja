package com.example.demo.src.users.user;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponseStatus;
import com.example.demo.config.secret.Secret;
import com.example.demo.src.users.Role;
import com.example.demo.src.users.user.model.GetUserLoginReq;
import com.example.demo.src.users.user.model.GetUserLoginRes;
import com.example.demo.src.users.user.model.User;
import com.example.demo.src.users.user.model.UserRepository;
import com.example.demo.utils.AES128;
import com.example.demo.utils.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProvider {
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public GetUserLoginRes getuserLogin(GetUserLoginReq requestDto) throws BaseException {
        User user = null; String password;
        if (requestDto.getIdOrEmail().contains("@")) {
            String email = requestDto.getIdOrEmail();
            user = userRepository.findByEmailAndStatus(requestDto.getIdOrEmail(), "ACTIVATED")
                    .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_LOGIN));
        } else {
            user = userRepository.findByIdAndStatus(requestDto.getIdOrEmail(), "ACTIVATED")
                    .orElseThrow(() -> new BaseException(BaseResponseStatus.FAILED_TO_LOGIN));
        }
        AES128 aes =  AES128.getInstance();

        try {
            password = aes.decrypt(user.getPassword());
            System.out.println("password:" + password);
        } catch (Exception exception) {
            throw new BaseException(BaseResponseStatus.PASSWORD_DECRYPTION_ERROR);
        }
        if (password.equals(requestDto.getPassword())) {
            String jwt = jwtService.createAccessToken(user.getIdx(), Role.USER.getKey());
            return new GetUserLoginRes(user.getIdx(), jwt);
        } else {
            throw new BaseException(BaseResponseStatus.FAILED_TO_LOGIN);
        }
    }
}
