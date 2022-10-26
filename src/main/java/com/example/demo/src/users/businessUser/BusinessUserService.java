package com.example.demo.src.users.businessUser;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponseStatus;
import com.example.demo.config.Status;
import com.example.demo.src.users.businessUser.model.BusinessUser;
import com.example.demo.src.users.businessUser.model.BusinessUserRepository;
import com.example.demo.src.users.businessUser.model.PostBusinessUserReq;
import com.example.demo.src.users.businessUser.model.PostBusinessUserRes;
import com.example.demo.utils.AES128;
import com.example.demo.utils.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class BusinessUserService {
    private final BusinessUserRepository businessUserRepository;
    private final JwtService jwtService;

    public PostBusinessUserRes postBusinessUser(PostBusinessUserReq requestDto) throws BaseException {
        if (businessUserRepository.findByIdAndStatus(requestDto.getId(), Status.ACTIVATED).isPresent())
            throw new BaseException(BaseResponseStatus.POST_USERS_EXISTS_ID);
        if (businessUserRepository.findByEmailAndStatus(requestDto.getEmail(), Status.ACTIVATED).isPresent())
            throw new BaseException(BaseResponseStatus.POST_USERS_EXISTS_EMAIL);
        if (businessUserRepository.findByPhoneAndStatus(requestDto.getPhone(), Status.ACTIVATED).isPresent())
            throw new BaseException(BaseResponseStatus.POST_USERS_EXISTS_PHONE);
        String encryptedPassword;
        try {
            encryptedPassword = AES128.getInstance().encrypt(requestDto.getPassword());
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.PASSWORD_ENCRYPTION_ERROR);
        }
        BusinessUser user = BusinessUser.builder()
                .id(requestDto.getId())
                .password(encryptedPassword)
                .name(requestDto.getName())
                .profileImageUrl(requestDto.getProfileImageUrl())
                .phone(requestDto.getPhone())
                .email(requestDto.getEmail())
               .build();
        BusinessUser registeredBusinessUser = businessUserRepository.save(user);

        return new PostBusinessUserRes(registeredBusinessUser.getId());
    }
}
