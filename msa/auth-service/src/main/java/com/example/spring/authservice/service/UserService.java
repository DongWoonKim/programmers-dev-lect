package com.example.spring.authservice.service;

import com.example.spring.authservice.domain.entity.User;
import com.example.spring.authservice.domain.repository.UserRepository;
import com.example.spring.authservice.dto.SignUpRequestDto;
import com.example.spring.authservice.exception.DuplicateUserIdException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signUp(SignUpRequestDto signUpRequestDto) {

        if ( userRepository.existsByUserId( signUpRequestDto.getUserId() ) ) {
            throw new DuplicateUserIdException("[회원가입] 이미 사용중인 아이디입니다.");
        }

        User user = signUpRequestDto.toUser(passwordEncoder.encode(signUpRequestDto.getPassword()));

        userRepository.save(user);
    }


}
