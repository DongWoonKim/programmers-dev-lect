package com.example.spring.springtheory.ch03.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface SimpleConnectionMaker {
    Connection makeNewConnection() throws ClassNotFoundException, SQLException;
}
