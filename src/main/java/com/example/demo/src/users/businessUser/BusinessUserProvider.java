package com.example.demo.src.users.businessUser;

import com.example.demo.config.BaseException;
import com.example.demo.config.Status;
import com.example.demo.config.secret.Secret;
import com.example.demo.src.users.Role;
import com.example.demo.src.users.businessUser.model.*;
import com.example.demo.utils.AES128;
import com.example.demo.utils.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

import static com.example.demo.config.BaseResponseStatus.*;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class BusinessUserProvider {
    private final BusinessUserRepository businessUserRepository;
private final AES128 aes128 = AES128.getInstance();
    private final JwtService jwtService;
    @Transactional(readOnly = true)
    public GetBusinessUserRes retrieveBusinessUser(Long userIdx) throws BaseException{
       return new GetBusinessUserRes(businessUserRepository.findById(userIdx)
                                        .orElseThrow(()->new BaseException(USERS_EMPTY_USER_IDX)));
    }

    public GetBusinessUserLoginRes getBusinessUserLogin(@Valid @RequestBody GetBusinessUserLoginReq requestDto) throws BaseException {
        BusinessUser user =businessUserRepository.findByIdAndStatus(requestDto.getId(), Status.ACTIVATED).orElseThrow(()->new BaseException(FAILED_TO_LOGIN));
        String decryptedPassword;
        try{
            decryptedPassword  = aes128.decrypt(user.getPassword());
        } catch(Exception e ){
            throw new BaseException(PASSWORD_DECRYPTION_ERROR);
        }
        if(!decryptedPassword.equals(requestDto.getPassword())){
            throw new BaseException(FAILED_TO_LOGIN);
        }
            String accessToken = jwtService.createAccessToken(user.getIdx(), Role.BUSINESS_USER.getKey());

        return new GetBusinessUserLoginRes(user.getIdx(),accessToken);
    }
}
