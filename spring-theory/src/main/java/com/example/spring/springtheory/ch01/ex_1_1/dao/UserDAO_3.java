package com.example.spring.springtheory.ch01.ex_1_1.dao;

import com.example.spring.springtheory.ch01.ex_1_1.domain.User;

import java.sql.*;

// * 문제점
// N사와 D사가 UserDAO구매를 희망 -> N사와 D사가 각기 다른 종류의 DB를 사용하고 싶다.
// 더 나아가서 UserDAO를 구매한 후에도 DB커넥션을 가져오는 방법을 변경될 수 있다.

// -> 고객에게 미리 컴파일된 클래스 바이너리 파일만 제공하고 싶은데,
// -> 이런 경우 UserDAO 소스코드를 N사와 D사에 제공해주지 않고도
// -> 고객 스스로 원하는 DB커넥션 생성 방식을 적용해가면서 UserDAO를 사용하게 할 수 있을까?

// "상속을 통한 확장"
// 클래스 계층구조를 통해 두 개의 관심이 독립적으로 분리되면서 변경 작업은 한층 용이해졌다.
// 새로운 DB 연결 방법을 적용해야 할 때는 UserDAO를 상속을 통해 확장해주기만 하면 된다.

public abstract class UserDAO_3 {

    public void add(User user) throws ClassNotFoundException, SQLException {

        String query = "INSERT INTO users (id, name, password) VALUES (?, ?, ?)";

        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
                ) {
            pstmt.setString(1, user.getId());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getPassword());
            pstmt.executeUpdate();
        }

    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        String query = "SELECT * FROM users WHERE id = ?";

        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            pstmt.setString(1, id);
            ResultSet resultSet = pstmt.executeQuery();

            resultSet.next();

            User user = new User();
            user.setId( resultSet.getString("id") );
            user.setName( resultSet.getString("name") );
            user.setPassword( resultSet.getString("password") );

            return user;
        }

    }

    // UserDAO의 소스코드를 제공하면, getConnection() 메서드를 원하는 방식으로 확장한후
    // UserDAO의 기능과 함께 사용할 수 있다.
    // 기존에는 같은 클래스에 다른 메서드로 분리됐던 DB 커넥션 연결이라는 관심을
    // 이번에는 상속을 통해 서브클래스로 분리해버리는 것이다.
    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;

}
