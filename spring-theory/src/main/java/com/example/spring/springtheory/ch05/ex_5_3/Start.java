package com.example.spring.springtheory.ch05.ex_5_3;

// * 서비스 추상화와 단일 책임 원칙
// * 문제점
// UserService가 한 클래스에 두 가지 책임을 갖고 있다.
// 1) 레벨 업그레이드 '비즈니스 로직'
// 2) 트랜잭션 경계 설정이라는 '기술적 관심사'
// -> 업무가 바뀌어도, 트랜잭션 기술이 바뀌어도 같은 파일을 고친다.

// '인터페이스 + 데코레이터'로 두 책임을 분리한다.

import com.example.spring.springtheory.ch05.ex_5_2.dao.DaoFactory;
import com.example.spring.springtheory.ch05.ex_5_2.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class Start {
    static void main(String[] args) throws SQLException, ClassNotFoundException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DaoFactory.class);
        UserService userService = context.getBean("userService", UserService.class);

        userService.upgradeLevels();
    }
}
