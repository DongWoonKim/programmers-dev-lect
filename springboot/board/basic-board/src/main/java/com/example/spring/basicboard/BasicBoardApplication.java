package com.example.spring.basicboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// * RESTful (REST, Representational State Transfer)
// 자원을 URI로 표현하고, HTTP메서드로 그 자원 대한 행위를 표현하는 API설계 원칙이다.
// controller의 매핑을 아래 규칙에 맞춰 설계하면 RESTful하다고 한다.

// * 핵심원칙
// 

@SpringBootApplication
public class BasicBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicBoardApplication.class, args);
    }

}
