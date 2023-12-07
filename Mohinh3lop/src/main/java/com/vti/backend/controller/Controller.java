package com.vti.backend.controller;

import com.vti.backend.service.IService;
import com.vti.backend.service.Service;
import com.vti.entity.User;

import java.sql.SQLException;
import java.util.List;

public class Controller {
    public IService userService = new Service();


    public List<User> getListUser() throws ClassNotFoundException, SQLException {
        // TODO Auto-generated method stub
        return userService.getListUser();
    }


    public User isLogin(String email, String password) throws SQLException, ClassNotFoundException {
        return userService.isLogin(email, password);
    }


    public void createEmployee(String fullName, String email) throws SQLException, ClassNotFoundException,Exception {
        // TODO Auto-generated method stub
        if (isUserExists(email)) {
            throw new Exception("user có email: " + email + " đã tồn tại");
        }
        userService.createEmployee(fullName, email);
    }


    public boolean isUserExists(String email) throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub
        return userService.isUserExists(email);
    }
}
