package com.example.spring.basicboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// * RESTful (REST, Representational State Transfer)
// 자원을 URI로 표현하고, HTTP메서드로 그 자원 대한 행위를 표현하는 API설계 원칙이다.
// controller의 매핑을 아래 규칙에 맞춰 설계하면 RESTful하다고 한다.

// * 핵심원칙
// - 자원 중심 URI : URI는 명사(자원)로, 동사는 쓰지 않는다. (ex, /boards (O), /getBoard (X))
// - HTTP 메서드로 행위 구분
// - GET : 조회 (예: GET /boards, GET /boards/1)
// - POST : 생성 (예: POST /boards)
// - PUT : 전체 수정 (예: PUT /boards/1)
// - PATCH : 부분 수정 (예: PATCH /boards/1)
// - DELETE : 삭제 (예: DELETE /boards/1)

// * 영속성

@SpringBootApplication
public class BasicBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicBoardApplication.class, args);
    }

}
