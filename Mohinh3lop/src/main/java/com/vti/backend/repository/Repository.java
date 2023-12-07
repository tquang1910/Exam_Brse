package com.vti.backend.repository;

import com.vti.entity.User;
import com.vti.utils.JDBCUTILS;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Repository implements IRepository{
    private JDBCUTILS jdbcUtils;

    public Repository() {
        // TODO Auto-generated constructor stub
        jdbcUtils = new JDBCUTILS();
    }


    @Override
    public List<User> getListUser() throws ClassNotFoundException, SQLException {
        // TODO Auto-generated method stub
        Connection connection = jdbcUtils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user");
        List<User> listUser = new ArrayList<User>();
        while (resultSet.next()) {
            User user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                    resultSet.getString(4));
            user.setExpInYear(resultSet.getByte(5));
            user.setProjectId(resultSet.getInt(7));
            user.setRole(User.Role.valueOf(resultSet.getString(8).toUpperCase()));
            listUser.add(user);

        }
        return listUser;
    }


    @Override
    public User isLogin(String email, String password) throws SQLException, ClassNotFoundException {
        Connection connection = jdbcUtils.getConnection();

        String sql = "SELECT * FROM `user` WHERE `email`=? AND `password`=?";


        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            User user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                    resultSet.getString(4));




            user.setExpInYear(resultSet.getByte(5));
            user.setProSkill(resultSet.getString(6));
            user.setProjectId(resultSet.getInt(7));
            user.setRole(User.Role.valueOf(resultSet.getString(8).toUpperCase()));
            return user;
        } else {
            return null;
        }
    }


    @Override
    public void createEmployee(String fullName, String email) throws SQLException, ClassNotFoundException {
        Connection connection =jdbcUtils.getConnection();
        String sql = "INSERT INTO user (fullname, email, password, role) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, fullName);
        preparedStatement.setString(2, email);
        preparedStatement.setString(3, "123456");
        preparedStatement.setString(4, "EMPLOYEE");

        int num = preparedStatement.executeUpdate();
        if (num>0) {
            System.out.println("tạo employee thành công");
        } else {
            System.out.println("tạo employee thất bại");
        }
    }


    @Override
    public boolean isUserExists(String email) throws SQLException, ClassNotFoundException {
        Connection connection = jdbcUtils.getConnection();
        String sql = "SELECT 1 FROM user WHERE email = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return true;
        } else {
            return false;
        }
    }
}
