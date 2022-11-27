# 📱숙소 예약 안드로이드 앱 제작 
- 숙소 예약 어플 **야놀자**를 벤치마킹한 안드로이드 앱 제작 개인 프로젝트
- 2021.06(2주, 개인 프로젝트)
## 👩‍ 💻Tech Used
```Spring Boot```, ```JPA```, ```JAVA```, ```Kotlin```, ```AWS EC2```, ```AWS RDS```, ```AWS S3```, ```Nginx```, ```Ubuntu```, ```Github```, ```Android```, ```Retrofit```
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
### 구현 기능
+ 숙소 조건 조회 및 상세 조회
+ 숙소 등록
+ 숙소 북마크
+ 리뷰 작성 및 조회
+ 일반 유저/ 비지니스 유저 로그인
+ 쿠폰 조회 및 적용

## 💫ERD
+  야놀자의 대표 기능인 숙소(hotel, motel) 조회하기/예약하기/리뷰쓰기/찜하기/결제하기 기능만을 대상으로 한 데이터베이스이다.
+ 숙소 유형별(모텔,호텔, 게스트하우스 등)에 따라 필요한 속성이 다르므로 개별의 테이블로 관리한다. 현재 데이터테이블에는 야놀자에서 가장 많이 예약되는 숙소 유형인 모텔 및 호텔에 관련된 테이블만 추가되어 있다.
+ 총 19개 테이블 포함
    + 유저 정보를 담은 테이블(일반 유저, 비지니스 유저): user, bussiness user
    + 호텔과 관련된 테이블                       : hotel, hotel_room, hotel_image, hotel_room_image, hotel_booking

    + 지역 구분을 담은 테이블                     : region
    + 예약 정보를 담은 테이블                     :booking, payment, refund
    + 발행된 쿠폰 정보를 담은 테이블                : coupon, user_coupon
    + 유저가 북마크(찜)한 숙소 정보를 담은 테이블      : bookmark
    + 유저가 남긴 숙소 리뷰 정보를 담은 테이블        : review,reviewReply  
    + 이미지 경로를 담은 테이블                    : image
    + 숙소 태그와 관련된 정보를 담은 테이블           : tag, accommodation_tag

## 💫API명세
+ 총 25개 AP
+ [API 명세 보러가기](https://docs.google.com/spreadsheets/d/1w7Z3xspfSeve4rfXSonxgaKw6YGtaYOJqTY23W1Ge-M/edit#gid=686050006)
