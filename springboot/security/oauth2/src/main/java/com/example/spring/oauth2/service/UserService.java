package com.example.spring.oauth2.service;

import com.example.spring.oauth2.domain.entity.User;
import com.example.spring.oauth2.domain.repository.UserRepository;
import com.example.spring.oauth2.dto.SignUpRequestDto;
import com.example.spring.oauth2.exception.DuplicateUserIdException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional( readOnly = true )
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signUp(SignUpRequestDto requestDto) {

        if ( userRepository.existsByUserId(requestDto.getUserId()) ) {
            throw new DuplicateUserIdException("[회원가입] 이미 사용중인 아이디입니다.");
        }

        User user = requestDto.toUser(passwordEncoder.encode(requestDto.getPassword()));

        userRepository.save(user);
    }

}
