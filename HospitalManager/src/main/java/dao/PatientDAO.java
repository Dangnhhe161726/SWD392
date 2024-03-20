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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Patient;
import model.User;

/**
 *
 * @author FPT SHOP
 */
public class PatientDAO extends DBContext{
    public int insertNewPatient(int user_id, String email,
            String first_name, String last_name, String password, boolean status, int role,
            int patient_id, String fullname, String dob,
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
                sql = "INSERT INTO `hospital`.`patient` VALUES(?,?,?,?,?,?,?)";
                PreparedStatement ps2 = connection.prepareStatement(sql);
                ps2.setInt(1, patient_id);
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
       public ArrayList<Patient> getallPatient() {
        ArrayList<Patient> listPatient = new ArrayList<>();
        String sql = "SELECT * FROM hospital.patient;";
        try {
            PreparedStatement statement = connection.prepareCall(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Patient p = new Patient(rs.getInt(1), rs.getString(2), rs.getDate(3),rs.getBoolean(4),rs.getString(5),rs.getString(6),rs.getInt(7));
                listPatient.add(p);
            }
            return listPatient;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
         public Patient GetPatient(String id) {
        try {
            String sql = "SELECT * FROM hospital.patient where id=?";
            PreparedStatement statement = connection.prepareCall(sql);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                  Patient p = new Patient(rs.getInt(1), rs.getString(2), rs.getDate(3),rs.getBoolean(4),rs.getString(5),rs.getString(6),rs.getInt(7));
                return p;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

     public void EditPatient(String fullname, String dob, String gender, String address, String phonenumber,String id) {
    try {
        String sql = "UPDATE hospital.patient SET fullname=?, dob=?, gender=?, address=?, phonenumber=? WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, fullname);
        preparedStatement.setString(2, dob);
        preparedStatement.setString(3, gender);
        preparedStatement.setString(4, address);
        preparedStatement.setString(5, phonenumber);
        preparedStatement.setString(6, id);

        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
 
public int insertUser(String firstname, String lastname, String email, String password, String status, String role) throws SQLException {
    String sql = "INSERT INTO hospital.user (email, first_name, last_name, password, status, role) VALUES (?, ?, ?, ?, ?, ?)";
    try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        statement.setString(1, email);
        statement.setString(2, firstname);
        statement.setString(3, lastname);
        statement.setString(4, password);
        statement.setInt(5, 1);
        statement.setInt(6, 1);

        int affectedRows = statement.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Creating user failed, no rows affected.");
        }

        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1); // Return the generated ID
            } else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        }
    }
}


       
       
       
  public void insertPatient(String fullname, String dob, String gender, String address, String phonenumber, int user_id) {
    try {
        // Check if the user_id exists in the user table before inserting
        if (!isUserIdExists(user_id)) {
            throw new SQLException("User ID does not exist in the user table.");
        }

        String sql = "INSERT INTO hospital.patient (fullname, dob, gender, address, phonenumber, user_id) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, fullname);
        statement.setString(2, dob);
        statement.setString(3, gender);
        statement.setString(4, address);
        statement.setString(5, phonenumber);
        statement.setInt(6, user_id);

        statement.executeUpdate();

        statement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
   private boolean isUserIdExists(int user_id) throws SQLException {
    String sql = "SELECT id FROM hospital.user WHERE id = ?";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, user_id);
        try (ResultSet resultSet = statement.executeQuery()) {
            return resultSet.next(); // Returns true if the user_id exists, false otherwise
        }
    }
}    
         
         public User GetUserById(String email,String password ) {
        try {
            String sql = "SELECT * FROM hospital.user where role=1 AND email=? AND password=?;";
            PreparedStatement statement = connection.prepareCall(sql);
            statement.setString(1, email);
                statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
            User U=new User(rs.getInt(1));
                return U;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    } 
public void deletePatient(String sid) {
    try {
        // Retrieve the user ID associated with the patient ID
        String userId = getUserIdForPatientId(sid);

        // If userId is not null, proceed with deleting both patient and user
        if (userId != null) {
            deletePatientAndUser(sid, userId);
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Log or handle the exception appropriately
    }
}

// Helper method to retrieve user ID associated with patient ID
private String getUserIdForPatientId(String sid) throws SQLException {
    String userId = null;
    String sql = "SELECT user_id FROM hospital.patient WHERE id=?";
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, sid);
    ResultSet resultSet = statement.executeQuery();
    if (resultSet.next()) {
        userId = resultSet.getString("user_id");
    }
    return userId;
}

// Method to delete both patient and user based on IDs
private void deletePatientAndUser(String patientId, String userId) throws SQLException {
    // Delete patient record
    String deletePatientSql = "DELETE FROM hospital.patient WHERE id=?";
    PreparedStatement deletePatientStatement = connection.prepareStatement(deletePatientSql);
    deletePatientStatement.setString(1, patientId);
    deletePatientStatement.executeUpdate();

    // Delete user record
    String deleteUserSql = "DELETE FROM hospital.user WHERE id=?";
    PreparedStatement deleteUserStatement = connection.prepareStatement(deleteUserSql);
    deleteUserStatement.setString(1, userId);
    deleteUserStatement.executeUpdate();
}

    
       
       
public static void main(String[] args) {
  PatientDAO p = new PatientDAO();
  
  p.deletePatient("14");
  
  
//int userId = -1; // Initialize user ID with a default value
//
//try {
//    // Insert the user and retrieve the generated ID
//    userId = p.insertUser("x", "a", "avc@gmail.com", "Secure@Pass123", "1", "1");
//    System.out.println("Generated User ID: " + userId); // Print the generated user ID
//
//    // Insert the patient with the generated user ID
//    p.insertPatient("dfsa", "2022-02-03", "1", "sd", "0915789987", userId);
//} catch (SQLException ex) {
//    Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, ex);
//}
p.deletePatient("15");
p.EditPatient("dfsdf", "2022-04-03", "1", "fsdafds", "0987876532", "1");
// Continue with any additional logic here...

}
//        ArrayList<Patient> listPatient =new ArrayList<>();
//        listPatient=p.getallPatient();
//           System.out.println(listPatient.toString());
    }
    
       
       

