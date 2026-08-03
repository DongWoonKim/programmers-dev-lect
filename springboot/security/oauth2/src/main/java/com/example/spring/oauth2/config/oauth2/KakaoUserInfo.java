package com.example.spring.oauth2.config.oauth2;

import java.util.Map;

// record란? (Java 16+) : 필드 나열만 하면 나머지 상용구를 컴파일러가 다 써주는, 불편 데이터 전용 클래스이다.
// 필드선언, 생성자, getter, equals/hashCode/toString까지 수십줄을 대신 해준다.
// record인 이유 : 상태는 응답 맵 하나뿐인 불변 값 객체이고,
// 컴포넌트 이름을 attributes로 지으면 인터페이스 attributes()가 자동 구현된다.

//   {
//     "id": 123456789,                          ← 회원번호(숫자). 유일하게 최상위에 있다
//     "kakao_account": {
//       "email": "user@example.com",            ← 동의 항목(비즈 앱)에 따라 아예 없을 수 있음
//       "profile": {
//         "nickname": "홍길동",
//         "profile_image_url": "https://..."
//       }
//     }
//   }

public record KakaoUserInfo(
        Map<String, Object> attributes
) implements OAuth2UserInfo {

    @Override
    public String id() {
        return "";
    }

    @Override
    public String email() {
        return "";
    }

    @Override
    public String name() {
        return "";
    }

    @Override
    public String imageUrl() {
        return "";
    }
}
