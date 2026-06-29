package com.example.spring.springtheory.ch05.ex_5_1.dao;


import com.example.spring.springtheory.ch05.ex_5_1.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO {

    private JdbcContext jdbcContext;

    protected UserDAO() {}

    public UserDAO(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    private RowMapper<User> userRowMapper = new RowMapper<>() {
        @Override
        public User mapRow(ResultSet rs) throws SQLException {
            User user = new User();
            user.setId( rs.getString("id") );
            user.setName( rs.getString("name") );
            user.setPassword( rs.getString("password") );
            user.setLevel( Level.valueOf(rs.getInt("level")) );
            user.setLogin( rs.getInt("login") );
            user.setRecommand( rs.getInt("recommand") );

            return user;
        }
    };

    public void add(User user) throws ClassNotFoundException, SQLException {

        StatementStrategy strategy = new StatementStrategy() {
            @Override
            public PreparedStatement makeStatement(Connection conn) throws SQLException {
                PreparedStatement pstmt = conn.prepareStatement(
                        "INSERT INTO users(id, name, password, level, login, recommend) VALUES(?, ?, ?, ?, ?, ?)"
                );

                pstmt.setString(1, user.getId());
                pstmt.setString(2, user.getName());
                pstmt.setString(3, user.getPassword());
                pstmt.setInt(4, user.getLevel().getValue());
                pstmt.setInt(5, user.getLogin());
                pstmt.setInt(6, user.getRecommand());

                return pstmt;
            }
        };

        jdbcContext.workWithStatementStrategy(strategy);
    }

    public void deleteAll() throws SQLException, ClassNotFoundException {

        StatementStrategy strategy = new StatementStrategy() {
            @Override
            public PreparedStatement makeStatement(Connection conn) throws SQLException {
                return conn.prepareStatement("DELETE FROM users");
            }
        };

        jdbcContext.workWithStatementStrategy(strategy);
    }

    public User get(String id) throws SQLException, ClassNotFoundException {
        StatementStrategy strategy = new StatementStrategy() {
            @Override
            public PreparedStatement makeStatement(Connection conn) throws SQLException {
                PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users WHERE id = ?");
                pstmt.setString(1, id);
                return pstmt;
            }
        };

        return jdbcContext.queryForObject( strategy, userRowMapper );
    }

    public List<User> getAll() throws SQLException, ClassNotFoundException {
        StatementStrategy strategy = new StatementStrategy() {
            @Override
            public PreparedStatement makeStatement(Connection conn) throws SQLException {
                PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users ORDER BY id");
                return pstmt;
            }
        };

        return jdbcContext.query(strategy, userRowMapper);
    }


}
