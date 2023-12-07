package com.vti.backend.repository;

import com.vti.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IRepository {
    List<User> getListUser() throws ClassNotFoundException, SQLException;

    User isLogin(String email, String password) throws SQLException, ClassNotFoundException;

    void createEmployee(String fullName, String email) throws SQLException, ClassNotFoundException;

    boolean isUserExists(String email) throws SQLException, ClassNotFoundException;
}
