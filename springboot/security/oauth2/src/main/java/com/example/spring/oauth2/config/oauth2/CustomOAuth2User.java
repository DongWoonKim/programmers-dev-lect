package com.example.spring.oauth2.config.oauth2;

import com.example.spring.oauth2.domain.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.List;
import java.util.Map;

// * CustomOAuth2User
// CustomUserDetails의 OAuth2 버전이다.
// - 자체 로그인 경로 : 시큐리티가 요구하는 표준 = UserDetails -> CustomUserDetails가 User를 감싼다.
// - 소셜 로그인 경로 : 시큐리티가 요구하는 표준 = OAuth2User -> 이 클래스가 User를 감싼다.
// 즉 이 클래스도 "우리 도메인(User)과 시큐리티 사이의 어댑터"이고,
// 어떤 경로로 로그인하든 principal에서 우리 User 엔티티를 꺼낼 수 있게 만드는 장치이다.

@Getter
@RequiredArgsConstructor
public class CustomOAuth2User implements OAuth2User {

    // 우리 DB 회원. SuccessHandler가 JWT 발급에 사용
    private final User user;

    // 어떤 SNS로 인증했는지
    private final AuthProvider provider;

    // 제공자 프로필의 공통 창구(다형성). 제공자별 파싱 결과가 필요할 때 사용
    private final OAuth2UserInfo userInfo;

    // 제공자가 준 원시 속성 맵
    // OAuth2User 계약상 보관 의무가 있고
    // userInfo가 안 꺼내주는 필드가 나중에 필요해질 때의 탈출구이기도하다.
    private final Map<String, Object> attributes;

    // 원시 맵에서 "사용자 식별자"를 가리키는 것. 제공자마다 다르다(kakao=id, google=sub)
    // application.yaml provider의 user-name-attribute 값이 여기까지 흘러들어온다.
    private final String nameAttributeKey;


    @Override
    public Map<String, Object> getAttributes() {
        return Map.of();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getName() {
        return "";
    }
}
