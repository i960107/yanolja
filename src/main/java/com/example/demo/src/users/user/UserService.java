package com.example.demo.src.users.user;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponseStatus;
import com.example.demo.config.secret.Secret;
import com.example.demo.src.users.user.model.*;
import com.example.demo.utils.AES128;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final Path root = Paths.get("/Users/i960107/pictures/yanolja");

    @Transactional
    public void save(PostUserReq postUserReq) throws BaseException {
    }

    @Transactional
    public User saveOAuthUser(PostOAuthUserReq postOAuthUserReq) {

        User user = userRepository.findByEmailAndSnsProviderAndStatus(postOAuthUserReq.getEmail(), postOAuthUserReq.getSnsProvider(), "ACTIVATED")
                .map(entity -> entity.updateOAuth(
                        postOAuthUserReq.getEmail(),
                        postOAuthUserReq.getProfileImageUrl(),
                        postOAuthUserReq.getSnsProvider(),
                        postOAuthUserReq.getSnsIdx(),
                        postOAuthUserReq.getSnsConnectedAt()))
                .orElse(postOAuthUserReq.toEntity());
        return userRepository.save(user);
    }

    @Transactional(rollbackFor = Exception.class)
    public PostUserRes postUserSignin(PostUserReq requestDto) throws BaseException {
        if (userRepository.findByEmailAndStatus(requestDto.getEmail(), "ACTIVATED").isPresent())
            throw new BaseException(BaseResponseStatus.POST_USERS_EXISTS_EMAIL);
        if (userRepository.findByIdAndStatus(requestDto.getId(), "ACTIVATED").isPresent())
            throw new BaseException(BaseResponseStatus.POST_USERS_EXISTS_ID);
        String encryptedPassword;
        try {
            encryptedPassword = AES128.getInstance().encrypt(requestDto.getPassword());
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.PASSWORD_ENCRYPTION_ERROR);
        }

        //파일 업로드
//        String profileImageUrl;w
//        String generatedFileName = UUID.randomUUID().toString();
//        try {
//            Files.copy(requestDto.getProfileImage().getInputStream(), this.root.resolve(generatedFileName));
//            profileImageUrl = root.resolve(generatedFileName).toString();
//        } catch (Exception e) {
//            throw new BaseException(BaseResponseStatus.IMAGE_UPLOAD_ERROR);
//        }
        User user = User.builder().id(requestDto.getId()).profileImageUrl(requestDto.getProfileImage()).password(encryptedPassword).phone(requestDto.getPhone()).name(requestDto.getName()).email(requestDto.getEmail()).nickName(requestDto.getNickName()).status("ACTIVATED").build();
        User signinedUser = userRepository.save(user);
        return new PostUserRes(signinedUser.getId());
    }
}
