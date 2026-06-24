package com.example.spring.springtheory.ch02.ex_2_1.dao;

import com.example.spring.springtheory.ch02.ex_2_1.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

// * @Autowired로 빈을 주입받으려면? -> 테스트를 '스프링 컨테이너 안에서' 실행해야 한다.
//   @SpringJUnitConfig(DaoFactory.class) 가 그 역할을 한다. 이 한 줄은 사실 두 가지를 합친 것이다.
//    1) @ExtendWith(SpringExtension.class) : JUnit5에 스프링 테스트 기능을 끼워 넣는다.
//    2) @ContextConfiguration(classes = DaoFactory.class) : 어떤 설정으로 컨테이너를 띄울지 지정.
//   -> 그래서 테스트 실행 시 스프링이 DaoFactory로 컨텍스트를 만들고,
//      @Autowired가 붙은 필드에 맞는 타입의 빈(UserDAO)을 자동으로 꽂아준다(필드 주입).
//   (애너테이션이 없으면 컨테이너가 없어 userDao가 null -> NullPointerException 발생)
@SpringJUnitConfig(DaoFactory.class)
class UserDAOTest {

    // @Autowired : 타입(UserDAO)이 일치하는 빈을 스프링이 찾아 이 필드에 주입해준다.
    @Autowired // 더 이상 직접 new AnnotationConfigApplicationContext / getBean 을 호출할 필요가 없다.
    private UserDAO userDAO;

    @Test
    void add_메서드_테스트() throws SQLException, ClassNotFoundException {
        // given
        User user = new User();
        user.setId("test123");
        user.setName("test234");
        user.setPassword("321");

        // when
        userDAO.add(user);

        // then
        assertEquals("test234", userDAO.get("test123").getName());
    }


}