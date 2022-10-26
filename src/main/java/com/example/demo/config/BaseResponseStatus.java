package com.example.demo.config;

import lombok.Getter;

/**
 * 에러 코드 관리
 */
@Getter
public enum BaseResponseStatus {
    /**
     * 1000 : 요청 성공
     */
    SUCCESS(true, 1000, "요청에 성공하였습니다."),


    /**
     * 2000 : Request 오류
     */
    // Common
    REQUEST_ERROR(false, 2000, "입력값을 확인해주세요."),
    EMPTY_TOKEN(false, 2001, "토큰을 입력해주세요."),
    EXPIRED_JWT(false, 2004, "만료된 JWT입니다"),

    INVALID_JWT(false, 2002, "유효하지 않은 JWT입니다."),
    INVALID_REFRESH_TOKEN(false, 2004, "유효하지 않은 refresh token입니다."),
    INVALID_USER_JWT(false, 2003, "권한이 없는 유저의 접근입니다."),

    // users
    USERS_EMPTY_USER_IDX(false, 2010, "유저 아이디(idx) 값을 확인해주세요."),
    TAGS_EMPTY_IDX(false, 2011, "존재하지 않는 tag입니다 "),
    // [POST] /users
    POST_USERS_EXISTS_EMAIL(false, 2017, "중복된 이메일입니다."),
    POST_USERS_EXISTS_ID(false, 2022, "중복된 아이디입니다."),
    POST_USERS_EXISTS_PHONE(false, 2023, "중복된 폰번호입니다."),
    POST_ACCOMMODATION_EXISTS_KAKAOPLACEID(false, 2024, "이미 등록된 장소입니다.(kakaoPlaceId중복)"),
    POST_ACCOMMODATION_IMAGE_INVALID_BUSINESS_USER(false, 2025, "권한이 없는 유저의 접근입니다. 유저가 관리하는 숙소가 아닙니다. "),



    /**
     * 3000 : Response 오류
     */
    // Common
    RESPONSE_ERROR(false, 3000, "값을 불러오는데 실패하였습니다."),
    ACCOMMODATION_IDX_ERROR(false,3003,"없는 숙소 idx 이거나 삭제된 숙소 idx 입니다."),
    ACCOMMODATION_ROOM_IDX_ERROR(false,3004,"없는 방 idx 입니다"),
    ACCOMMODATION_TYPE_ERROR(false,3005,"잘못된 숙소 타입입니다"),
    // [POST] /users
    DUPLICATED_EMAIL(false, 3013, "중복된 이메일입니다."),
    FAILED_TO_LOGIN(false,3014,"없는 아이디거나 비밀번호가 틀렸습니다."),

    //Review
    /**
     * 4000 : Database, Server 오류
     */
    DATABASE_ERROR(false, 4000, "데이터베이스 연결에 실패하였습니다."),
    SERVER_ERROR(false, 4001, "서버와의 연결에 실패하였습니다."),
    OAUTH_LOGIN_ERROR(false,4002,"OAuth 서비스 제공 서버와의 연결에 실패하였습니다"),
    IMAGE_UPLOAD_ERROR(false,4003,"이미지 업로드에 실패하였습니다"),
    SERVER_EXCEPTION(false, 5000, "서버 에러 발생"),
    SERVER_RUNTIME_EXCEPTION(false, 5000, "서버 런타임 에러 발생"),



    //[PATCH] /users/{userIdx}
    MODIFY_FAIL_USERNAME(false,4014,"유저네임 수정 실패"),

    PASSWORD_ENCRYPTION_ERROR(false, 4011, "비밀번호 암호화에 실패하였습니다."),
    PASSWORD_DECRYPTION_ERROR(false, 4012, "비밀번호 복호화에 실패하였습니다.");


    // 5000 : 필요시 만들어서 쓰세요;

    // 6000 : 필요시 만들어서 쓰세요


    private final boolean isSuccess;
    private final int code;
    private final String message;

    private BaseResponseStatus(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}
