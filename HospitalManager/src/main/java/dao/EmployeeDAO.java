/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author FPT SHOP
 */
public class EmployeeDAO extends DBContext {
    public int insertNewEmployee(int user_id, String email,
            String first_name, String last_name, String password, boolean status, int role,
            int employee_id, String fullname, String dob,
            boolean gender, String address, String phonenumber) {
        int n = 0;
        String sql = "INSERT INTO `hospital`.`user` VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, user_id);
            ps.setString(2, email);
            ps.setString(3, first_name);
            ps.setString(4, last_name);
            ps.setString(5, password);
            ps.setBoolean(6, status);
            ps.setInt(7, role);
            ps.executeUpdate();

            sql = "SELECT @User_Id := MAX(user.id) FROM hospital.user;";
            ResultSet rs = connection.createStatement().executeQuery(sql);

            if (rs.next()) {
                int userId = rs.getInt(1);
                sql = "INSERT INTO `hospital`.`employee` VALUES(?,?,?,?,?,?,?)";
                PreparedStatement ps2 = connection.prepareStatement(sql);
                ps2.setInt(1, employee_id);
                ps2.setString(2, fullname);
                ps2.setString(3, dob);
                ps2.setBoolean(4, gender);
                ps2.setString(5, address);
                ps2.setString(6, phonenumber);
                ps2.setInt(7, userId);
                n = ps2.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }
public List<Employee> getAllEm() {
        List<Employee> list = new ArrayList<>();
        String query = "select * from hospital.employee";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Employee(rs.getInt(1),
                        rs.getString(2), rs.getString(3),
                        rs.getBoolean(4), rs.getString(5),
                        rs.getString(6), rs.getInt(7)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public Employee getEmId(String id) {
        String query = "select * from hospital.employee WHERE (`id` = ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Employee(rs.getInt(1),
                        rs.getString(2), rs.getString(3),
                        rs.getBoolean(4), rs.getString(5),
                        rs.getString(6), rs.getInt(7));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public void deleteEmployee(String id) {
        String query = "DELETE FROM `hospital`.`employee` WHERE (`id` = ?);";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

//    public void insertEmployee(String id, String fullname, String dob,
//            String gender, String address, String phonenumber, String user_id) {
//        String query = "INSERT INTO `hospital`.`employee` "
//                + "(`id`, `fullname`, `dob`, `gender`, `address`, `phonenumber`, `user_id`) "
//                + "VALUES (?,?,?,?,?,?,?);";
//        try {
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setString(1, id);
//
//            ps.setString(2, fullname);
//            ps.setString(3, dob);
//            ps.setString(4, gender);
//            ps.setString(5, address);
//            ps.setString(6, phonenumber);
//            ps.setString(7, user_id);
//            ps.executeUpdate();
//        } catch (Exception e) {
//        }
//    }
public void insertEmployee( String fullname, String dob,
            String gender, String address, String phonenumber, String user_id) {
        String query = "INSERT INTO `hospital`.`employee` "
                + "( `fullname`, `dob`, `gender`, `address`, `phonenumber`, `user_id`) "
                + "VALUES (?,?,?,?,?,?);";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
          

            ps.setString(1, fullname);
            ps.setString(2, dob);
            ps.setString(3, gender);
            ps.setString(4, address);
            ps.setString(5, phonenumber);
            ps.setString(6, user_id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public void updateEmployee(String id, String user_id, String fullname, String dob, String gender, String address, String phonenumber) {
        String query = "UPDATE `hospital`.`employee` SET "
                + "`fullname` = ?, `dob` = ?, `gender` = ?, "
                + "`address` = ?, `phonenumber` = ?, `user_id` = ? WHERE (`id` = ?);";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, fullname);
            ps.setString(2, dob);
            ps.setString(3, gender);
            ps.setString(4, address);
            ps.setString(5, phonenumber);
            ps.setString(6, user_id);
            ps.setString(7, id);
            ps.executeUpdate();
        } catch (Exception e) {
            // X? lý ngo?i l?
            e.printStackTrace();
        }
    }
//    public static void main(String[] args) {
//        EmployeeDAO sc = new EmployeeDAO();
//
//        System.out.println(sc.getAllEm());
//    UPDATE `hospital`.`employee` SET `fullname` = 'qw1', `dob` = '1999-02-02 00:00:00.0000001', `gender` = '2', `address` = 'hn1', `phonenumber` = '12345678901', `user_id` = '61' WHERE (`id` = '2');
////INSERT INTO `hospital`.`employee` (`id`, `fullname`, `dob`, `gender`, `address`, `phonenumber`, `user_id`) VALUES ('2', 'qw', '1999-02-02', '1', 'hn', '1234567890', '6');
//    }
}
}
