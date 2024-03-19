/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author FPT SHOP
 */
public class UserDAO extends DBContext {

    public List<User> getAllUser() {
        List<User> userList = new ArrayList<>();
        String sql = "select * from user";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getBoolean(6),
                        rs.getInt(7));
                userList.add(u);
            }
        } catch (SQLException ex) {
            System.out.println("Cant get User Inforamtion");
        }
        return userList;
    }

    public User getUserByEmailAndPass(String username, String password) {
        String sql = "select * from user where email = ? and password= ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getBoolean(6),
                        rs.getInt(7));
            }
        } catch (SQLException ex) {
            System.out.println("Cant get User Inforamtion");
        }
        return null;
    }

    public void InsertNewUser(int Id, String email, String first_name, String last_name, String password, boolean status, int role_id) {
        String sql = "insert into user values (?,?,?,?,?,?,?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Id);
            ps.setString(2, email);
            ps.setString(3, first_name);
            ps.setString(4, last_name);
            ps.setString(5, password);
            ps.setBoolean(6, status);
            ps.setInt(7, role_id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void updateUserDetail(String id, String role, String status) {
        try {
            String sql = "update user set role=?,status=? where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, role);
            preparedStatement.setString(2, status);
            preparedStatement.setString(3, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User getUserInfomation(int id) {

        try {

            String sql = "select * from user u where u.id = ?";
            PreparedStatement statement = connection.prepareCall(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("email"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("password"), rs.getBoolean("status"), rs.getInt("role"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
