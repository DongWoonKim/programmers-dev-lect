package com.example.spring.authservice.controller;

import com.example.spring.authservice.dto.SignInRequestDto;
import com.example.spring.authservice.dto.SignInResponseDto;
import com.example.spring.authservice.dto.SignUpRequestDto;
import com.example.spring.authservice.dto.SignUpResponseDto;
import com.example.spring.authservice.service.UserService;
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

    @PostMapping("/join")
    public SignUpResponseDto join(@RequestBody SignUpRequestDto signUpRequestDto) {

        userService.signUp(signUpRequestDto);

        return SignUpResponseDto.builder()
                .url("/users/login")
                .build();
    }

    @PostMapping("/login")
    public SignInResponseDto login(
            @RequestBody SignInRequestDto signInRequestDto,
            HttpServletResponse response
    ) {
        System.out.println("signInRequestDto = " + signInRequestDto);
        return SignInResponseDto.builder().build();
    }

}
