package com.example.spring.springtheory.ch01.ex_1_4;

// * 문제점?
// Client는 기존에 UserDAO가 직접 당당하는 기능,
// 즉 어떤 ConnectionMaker 구현 클래스를 사용할지를 결정하는 기능을 엉겁결에 떠맡았다.
// 그런데 원래 Start.java는 UserDAO의 기능이 잘 동작하는지를 테트스트하려고 만든 것이다.
// 그런데 지금 또 다른 책임까지 떠맡고 있으니 뭔가 문제가 있다.

// '오브젝트 팩토리'
// 객체의 생성 방법을 결정하고 그렇게 만들어진 오브젝트를 돌려주는 일을 하는 오브젝트를 '팩토리'라고 한다.

import com.example.spring.springtheory.ch01.ex_1_4.dao.DaoFactory;
import com.example.spring.springtheory.ch01.ex_1_4.dao.UserDAO;

public class Start {
    static void main(String[] args) {
        UserDAO dao = new DaoFactory().userDAO();
    }
}
