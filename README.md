# 📱숙소 예약 안드로이드 앱 제작 - 2021.06(2주, 개인 프로젝트)

숙소 예약 어플 야놀자를 벤치마킹한 안드로이드 앱 제작 개인 프로젝트
## 👩‍ 💻Tech Used
Spring Boot, JPA, JAVA, Kotlin, AWS EC2, AWS RDS, AWS S3, Nginx, Ubuntu, Github, Android, Retrofit
## ✔️ 프로젝트 내용
### 백엔드
+ AWS EC2를 활용하여 Linux(Ubuntu)기반 테스트 서버 및 프로덕트 서버 구축.
+ AWS RDS를 활용하여 MySQL DB를 구축하고 요구사항 분석을 바탕으로 확장성과 정규화를 고려한 DB설계.
+ 다양한 오류 상황에 맞는 커스텀 에러 발생시켜 클라이언트에 오류에 대한 정보 제공
### 프론트엔드
+ 다양한 레이아웃에 대한 이해를 바탕으로 화면별 적절한 레이아웃 구성
+ Thread를 이용한 배너 자동 스크롤
+ CustomDialog 구현
+ ActivityLifeCycle 및 SharedPreference를 활용하여 자동 로그인 구현
+ Retrofit, glide, gson등의 라이브러리를 활용하여 API 연동

## 💫ERD
+ !클릭 필요
<img src="./docs/yanolja-ERD.png" width="2000px" height="600px" title="erd"/>

## 💫API명세
+ !클릭 필요
https://docs.google.com/spreadsheets/d/1w7Z3xspfSeve4rfXSonxgaKw6YGtaYOJqTY23W1Ge-M/edit#gid=686050006

## ✨Structure
```text
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── example
    │   │           └── demo
    │   │               ├── DemoApplication.java
    │   │               ├── config
    │   │               │   ├── Auth.java
    │   │               │   ├── BaseException.java
    │   │               │   ├── BaseResponse.java
    │   │               │   ├── BaseResponseStatus.java
    │   │               │   ├── BaseTimeEntity.java
    │   │               │   ├── Status.java
    │   │               │   ├── auth
    │   │               │   │   ├── CustomOAuth2UserService.java
    │   │               │   │   ├── OAuthSuccessHandler.java
    │   │               │   │   └── dto
    │   │               │   │       └── OAuthAttributes.java
    │   │               │   ├── interceptor
    │   │               │   │   ├── DefaultControllerAdvice.java
    │   │               │   │   └── DefaultInterceptor.java
    │   │               │   └── secret
    │   │               │       └── Secret.java
    │   │               ├── src
    │   │               │   ├── WebMvcConfig.java
    │   │               │   ├── WebSecurityConfig.java
    │   │               │   ├── booking
    │   │               │   │   ├── BookingController.java
    │   │               │   │   ├── BookingProvider.java
    │   │               │   │   ├── BookingService.java
    │   │               │   │   └── model
    │   │               │   │       ├── Booking.java
    │   │               │   │       ├── BookingRepository.java
    │   │               │   │       ├── GetBookingListRes.java
    │   │               │   │       └── GetBookingRes.java
    │   │               │   ├── bookmark
    │   │               │   │   ├── BookmarkController.java
    │   │               │   │   ├── BookmarkProvider.java
    │   │               │   │   ├── BookmarkService.java
    │   │               │   │   └── model
    │   │               │   │       ├── Bookmark.java
    │   │               │   │       ├── BookmarkRepository.java
    │   │               │   │       ├── BookmarkedAccommodation.java
    │   │               │   │       └── GetBookmarkListRes.java
    │   │               │   ├── coupon
    │   │               │   │   ├── CouponController.java
    │   │               │   │   ├── CouponProvider.java
    │   │               │   │   ├── CouponService.java
    │   │               │   │   └── model
    │   │               │   │       ├── Coupon.java
    │   │               │   │       ├── CouponRepository.java
    │   │               │   │       ├── GetCouponRes.java
    │   │               │   │       └── UserCoupon.java
    │   │               │   ├── hotel
    │   │               │   │   ├── HotelController.java
    │   │               │   │   ├── HotelProvider.java
    │   │               │   │   ├── HotelService.java
    │   │               │   │   └── model
    │   │               │   │       ├── DeleteHotelRes.java
    │   │               │   │       ├── GetHotelImageRes.java
    │   │               │   │       ├── GetHotelListRes.java
    │   │               │   │       ├── GetHotelRes.java
    │   │               │   │       ├── GetHotelRoomRes.java
    │   │               │   │       ├── HotelRoomRepository.java
    │   │               │   │       ├── PatchHotelReq.java
    │   │               │   │       ├── PatchHotelRes.java
    │   │               │   │       ├── PostHotelImageReq.java
    │   │               │   │       ├── PostHotelImageRes.java
    │   │               │   │       ├── PostHotelReq.java
    │   │               │   │       ├── PostHotelRes.java
    │   │               │   │       ├── PostHotelTagReq.java
    │   │               │   │       ├── PostHotelTagRes.java
    │   │               │   │       ├── PutHotelReq.java
    │   │               │   │       └── entity
    │   │               │   │           ├── Hotel.java
    │   │               │   │           ├── HotelRepository.java
    │   │               │   │           └── HotelRoom.java
    │   │               │   ├── image
    │   │               │   │   ├── ImageController.java
    │   │               │   │   ├── ImageProvider.java
    │   │               │   │   ├── ImageService.java
    │   │               │   │   ├── demo
    │   │               │   │   └── model
    │   │               │   │       └── entity
    │   │               │   │           ├── HotelImage.java
    │   │               │   │           ├── HotelImageRepository.java
    │   │               │   │           ├── HotelRoomImage.java
    │   │               │   │           ├── HotelRoomImageRepository.java
    │   │               │   │           ├── Image.java
    │   │               │   │           ├── ImageRepository.java
    │   │               │   │           ├── MotelImage.java
    │   │               │   │           ├── MotelImageRepository.java
    │   │               │   │           ├── MotelRoomImage.java
    │   │               │   │           ├── MotelRoomImageRepository.java
    │   │               │   │           └── dto
    │   │               │   ├── motel
    │   │               │   │   ├── MotelController.java
    │   │               │   │   ├── MotelProvider.java
    │   │               │   │   ├── MotelService.java
    │   │               │   │   └── model
    │   │               │   │       ├── GetMotelRes.java
    │   │               │   │       ├── GetMotelRoomRes.java
    │   │               │   │       ├── Motel.java
    │   │               │   │       ├── MotelRepository.java
    │   │               │   │       ├── MotelRoom.java
    │   │               │   │       ├── MotelRoomRepository.java
    │   │               │   │       └── PostMotelReq.java
    │   │               │   ├── payment
    │   │               │   │   ├── PaymentController.java
    │   │               │   │   ├── PaymentProvider.java
    │   │               │   │   ├── PaymentService.java
    │   │               │   │   └── model
    │   │               │   │       ├── Payment.java
    │   │               │   │       └── PaymentRepository.java
    │   │               │   ├── recommendation
    │   │               │   │   ├── RecommendationController.java
    │   │               │   │   ├── RecommendationProvider.java
    │   │               │   │   ├── RecommendationService.java
    │   │               │   │   └── model
    │   │               │   │       ├── GetRecommendationRes.java
    │   │               │   │       ├── Recommendation.java
    │   │               │   │       └── RecommendationRepository.java
    │   │               │   ├── refund
    │   │               │   │   ├── RefundController.java
    │   │               │   │   ├── RefundProvider.java
    │   │               │   │   ├── RefundService.java
    │   │               │   │   └── model
    │   │               │   │       ├── Refund.java
    │   │               │   │       └── RefundRepository.java
    │   │               │   ├── region
    │   │               │   │   ├── RegionController.java
    │   │               │   │   ├── RegionProvider.java
    │   │               │   │   ├── RegionService.java
    │   │               │   │   └── model
    │   │               │   │       ├── GetRegionRes.java
    │   │               │   │       ├── Region.java
    │   │               │   │       └── RegionRepository.java
    │   │               │   ├── review
    │   │               │   │   ├── ReviewController.java
    │   │               │   │   ├── ReviewProvider.java
    │   │               │   │   ├── ReviewService.java
    │   │               │   │   └── model
    │   │               │   │       ├── GetRatingRes.java
    │   │               │   │       ├── GetReviewReplyRes.java
    │   │               │   │       ├── GetReviewRes.java
    │   │               │   │       ├── Review.java
    │   │               │   │       ├── ReviewReply.java
    │   │               │   │       ├── ReviewReplyRepository.java
    │   │               │   │       └── ReviewRepository.java
    │   │               │   ├── reviewReply
    │   │               │   ├── tag
    │   │               │   │   ├── TagController.java
    │   │               │   │   ├── TagProvider.java
    │   │               │   │   ├── TagService.java
    │   │               │   │   └── model
    │   │               │   │       ├── AccommodationTag.java
    │   │               │   │       ├── GetTagRes.java
    │   │               │   │       ├── Tag.java
    │   │               │   │       └── TagRepository.java
    │   │               │   ├── test
    │   │               │   │   └── TestController.java
    │   │               │   └── users
    │   │               │       ├── CustomUserDetailService.java
    │   │               │       ├── Role.java
    │   │               │       ├── businessUser
    │   │               │       │   ├── BusinessUserController.java
    │   │               │       │   ├── BusinessUserProvider.java
    │   │               │       │   ├── BusinessUserService.java
    │   │               │       │   └── model
    │   │               │       │       ├── BusinessUser.java
    │   │               │       │       ├── BusinessUserRepository.java
    │   │               │       │       ├── GetBusinessUserLoginReq.java
    │   │               │       │       ├── GetBusinessUserLoginRes.java
    │   │               │       │       ├── GetBusinessUserRes.java
    │   │               │       │       ├── PostBusinessUserReq.java
    │   │               │       │       └── PostBusinessUserRes.java
    │   │               │       └── user
    │   │               │           ├── OAuthController.java
    │   │               │           ├── OAuthProvider.java
    │   │               │           ├── UserController.java
    │   │               │           ├── UserProvider.java
    │   │               │           ├── UserService.java
    │   │               │           └── model
    │   │               │               ├── GetAccessTokenReq.java
    │   │               │               ├── GetAccessTokenRes.java
    │   │               │               ├── GetUserLoginReq.java
    │   │               │               ├── GetUserLoginRes.java
    │   │               │               ├── GetUserRes.java
    │   │               │               ├── PostOAuthUserReq.java
    │   │               │               ├── PostOAuthUserRes.java
    │   │               │               ├── PostUserReq.java
    │   │               │               ├── PostUserRes.java
    │   │               │               ├── User.java
    │   │               │               └── UserRepository.java
    │   │               └── utils
    │   │                   ├── AES128.java
    │   │                   ├── JwtService.java
    │   │                   ├── PasswordService.java
    │   │                   └── ValidationRegex.java
    │   └── resources
    │       ├── application-oauth.yml
    │       ├── application-prod.yml
    │       ├── application-test.yml
    │       ├── application.yml
    │       ├── logback-spring.xml
    │       └── templates
    │           ├── callback.mustache
    │           └── index.mustache

```
