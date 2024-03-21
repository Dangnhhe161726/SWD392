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
import java.util.ArrayList;
import java.util.List;
import model.Doctor;

/**
 *
 * @author FPT SHOP
 */
public class DoctorDAO extends DBContext {

    public int insertNewDoctor(int user_id, String email,
            String first_name, String last_name, String password, boolean status, int role,
            int doctor_id, String fullname, String dob,
            boolean gender, String address, String specialization, String qualification, String phonenumber) {
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
                sql = "INSERT INTO `hospital`.`doctor` VALUES(?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps2 = connection.prepareStatement(sql);
                ps2.setInt(1, doctor_id);
                ps2.setString(2, fullname);
                ps2.setString(3, dob);
                ps2.setBoolean(4, gender);
                ps2.setString(5, address);
                ps2.setString(6, specialization);
                ps2.setString(7, qualification);
                ps2.setString(8, phonenumber);
                ps2.setInt(9, userId);
                n = ps2.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    public List<Doctor> getAllDoctor() {
        List<Doctor> doctors = new ArrayList<>();
        String sql = "SELECT * FROM doctor;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Doctor doctor = Doctor.builder()
                        .id(rs.getInt("id"))
                        .fullname(rs.getString("fullname"))
//                        .dob(rs.getDate("dob"))
//                        .gender(rs.getBoolean("gender"))
//                        .address(rs.getString("address"))
//                        .specialization(rs.getString("specialization"))
//                        .qualification(rs.getString("qualification"))
//                        .phonenumber(rs.getString("phonenumber"))
                        .build();
                doctors.add(doctor);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); 
        }
        return doctors;
    }

}
