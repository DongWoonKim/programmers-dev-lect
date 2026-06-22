package com.example.spring.springtheory.ch01.ex_1_3;

import com.example.spring.springtheory.ch01.ex_1_3.dao.DConnectionMaker;
import com.example.spring.springtheory.ch01.ex_1_3.dao.SimpleConnectionMaker;
import com.example.spring.springtheory.ch01.ex_1_3.dao.UserDAO;

public class Start {
    static void main(String[] args) {

        SimpleConnectionMaker conn = new DConnectionMaker();
        UserDAO userDAO = new UserDAO(conn);

    }
}
