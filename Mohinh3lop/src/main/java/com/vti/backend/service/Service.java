package com.vti.backend.service;

import com.vti.backend.repository.IRepository;
import com.vti.backend.repository.Repository;
import com.vti.entity.User;

import java.sql.SQLException;
import java.util.List;

public class Service implements IService {

    public IRepository userRepository = new Repository();

    @Override
    public List<User> getListUser() throws ClassNotFoundException, SQLException {
        // TODO Auto-generated method stub
        return userRepository.getListUser();
    }

    @Override
    public User isLogin(String email, String password) throws SQLException, ClassNotFoundException {
        return userRepository.isLogin(email, password);
    }

    @Override
    public void createEmployee(String fullName, String email) throws SQLException, ClassNotFoundException,Exception {
        // TODO Auto-generated method stub
        if (isUserExists(email)) {
            throw new Exception("user có email: " + email + " đã tồn tại");
        }
        userRepository.createEmployee(fullName, email);
    }

    @Override
    public boolean isUserExists(String email) throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub
        return userRepository.isUserExists(email);
    }

}
