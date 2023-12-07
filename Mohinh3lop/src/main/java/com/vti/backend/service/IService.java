package com.vti.backend.service;

import com.vti.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IService {
    List<User> getListUser() throws ClassNotFoundException, SQLException;

    User isLogin(String email, String password) throws SQLException, ClassNotFoundException;

    void createEmployee(String fullName, String email) throws SQLException, ClassNotFoundException, Exception;

    boolean isUserExists(String email) throws SQLException, ClassNotFoundException;
}
