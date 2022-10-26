//package com.example.demo.config.auth;
//
//import com.example.demo.config.auth.dto.OAuthAttributes;
//import com.example.demo.src.users.Role;
//import com.example.demo.src.users.user.model.User;
//import com.example.demo.src.users.user.model.UserRepository;
//import com.example.demo.utils.JwtService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
//import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
//import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//
//@RequiredArgsConstructor
//@Service
//public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
//
//    private final UserRepository userRepository;
//    private String userNameAttributeName;
//
//    @Override
//    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
//        OAuth2User oAuth2User = delegate.loadUser(userRequest);
//
//        String registrationId = userRequest.getClientRegistration().getRegistrationId();
//
//        // Unnecessary for naver, kakao
//        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
//                .getUserInfoEndpoint().getUserNameAttributeName();
//
//        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());
//
//
//        User user = saveOrUpdate(attributes);
//
//        return new DefaultOAuth2User(
//                Collections.singleton(new SimpleGrantedAuthority(Role.USER.getKey())),
//                attributes.getAttributes(),
//                attributes.getNameAttributeKey());
//    }
//
//    private User saveOrUpdate(OAuthAttributes attributes) {
//        User user = userRepository.findByEmailAndSnsProviderAndStatus(attributes.getEmail(), attributes.getSnsProvider(), "ACTIVATED")
//                .map(entity -> entity.update(attributes.getName(), attributes.getPicture(), attributes.getEmail()))
//                .orElse(attributes.toEntity());
//
//        return userRepository.save(user);
//    }
//}
