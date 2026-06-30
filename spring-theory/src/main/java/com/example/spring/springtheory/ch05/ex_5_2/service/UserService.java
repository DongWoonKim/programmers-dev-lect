package com.example.spring.springtheory.ch05.ex_5_2.service;

import com.example.spring.springtheory.ch05.ex_5_2.dao.Level;
import com.example.spring.springtheory.ch05.ex_5_2.dao.UserDAO;
import com.example.spring.springtheory.ch05.ex_5_2.domain.User;

import java.sql.SQLException;
import java.util.List;

// * UserService - 사용자 레벨 관리 '비즈니스 로직'을 담는 계층

public class UserService {

    public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
    public static final int MIN_RECOMMEND_FOR_GOLD = 30;

    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    // 신규가입
    public void add(User user) throws SQLException, ClassNotFoundException {
        user.setLevel( Level.BASIC );
        userDAO.add(user);
    }

    // 업그레이드 담당
    public void upgradeLevels() throws SQLException, ClassNotFoundException {
        List<User> users = userDAO.getAll();
        for ( User user : users ) {
            if ( canUpgrade(user) ) {
                upgradeLevel(user);
            }
        }

    }

    // '올릴 수 있는가'
    private boolean canUpgrade(User user) {
        Level curLevel = user.getLevel();
        switch (curLevel) {
            case BASIC:
                return user.getLogin() >= MIN_LOGCOUNT_FOR_SILVER;
            case SILVER:
                return user.getRecommand() >= MIN_RECOMMEND_FOR_GOLD;
            case GOLD:
                return false;
            default:
                throw new IllegalStateException("Unexpected value: " + curLevel);
        }
    }

    // 실제 업그레드
    protected void upgradeLevel(User user) throws SQLException, ClassNotFoundException {
        user.upgradeLevel();
        userDAO.update(user);
    }

}
