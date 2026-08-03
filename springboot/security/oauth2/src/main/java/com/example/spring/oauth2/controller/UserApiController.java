package com.example.spring.oauth2.controller;

import com.example.spring.oauth2.config.jwt.JwtProperties;
import com.example.spring.oauth2.dto.*;
import com.example.spring.oauth2.service.UserService;
import com.example.spring.oauth2.util.CookieUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserApiController {

    private final UserService userService;
    private final JwtProperties jwtProperties;

    @PostMapping("/join")
    public SignUpResponseDto join(@RequestBody SignUpRequestDto requestDto ) {
        userService.signUp(requestDto);
        return SignUpResponseDto.builder()
                .url("/users/login")
                .build();
    }

    @PostMapping("/login")
    public SignInResponseDto login(
            @RequestBody SignInRequestDto requestDto,
            HttpServletResponse response
    ) {
        SignInResponseDto signInResponseDto = userService.login(requestDto);

        CookieUtil.addCookie(
                response,
                CookieUtil.REFRESH_TOKEN_COOKIE,
                signInResponseDto.getRefreshToken(),
                (int) jwtProperties.getRefreshTokenValidity().toSeconds()
        );

        signInResponseDto.setRefreshToken(null);

        return signInResponseDto;
    }

    @PostMapping("/logout")
    public LogoutResponseDto logout(
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        CookieUtil.deleteCookie(request, response, CookieUtil.REFRESH_TOKEN_COOKIE);
        return LogoutResponseDto.builder()
                .message("로그아웃 되었습니다.")
                .url("/users/login")
                .build();
    }

}
