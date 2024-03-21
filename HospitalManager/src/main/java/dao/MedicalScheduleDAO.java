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
import model.Doctor;
import model.MedicalHistory;
import model.Patient;
import model.Status;

/**
 *
 * @author Windows 11
 */
public class MedicalScheduleDAO extends DBContext {

    public List<MedicalHistory> getAllMedicalHistory() {
        List<MedicalHistory> medicalHistorys = new ArrayList<>();
        String sql = "SELECT m.id, m.examination_date, m.diagnosis, m.prescription, o.fullname as doctorName, p.fullname as patientName, s.`name`, s.id as statusName, o.id as doctorId, p.id as patientId FROM medicalhistory m\n"
                + "JOIN doctor o on m.doctor_id = o.id\n"
                + "JOIN patient p on m.patient_id = p.id\n"
                + "JOIN `status` s on s.id = m.status_id;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MedicalHistory medicalHistory = MedicalHistory.builder()
                        .id(rs.getInt("id"))
                        .examinationDate(rs.getDate("examination_date"))
                        .diagnosis(rs.getString("diagnosis"))
                        .prescription(rs.getString("prescription"))
                        .doctor(Doctor
                                .builder()
                                .fullname(rs.getString("doctorName"))
                                .id(rs.getInt("doctorId"))
                                .build())
                        .patient(Patient
                                .builder()
                                .fullname(rs.getString("patientName"))
                                .id(rs.getInt("patientId"))
                                .build())
                        .status(Status
                                .builder()
                                .id(rs.getInt("statusName"))
                                .name(rs.getString("name"))
                                .build())
                        .build();
                medicalHistorys.add(medicalHistory);
            }
            return medicalHistorys;
        } catch (SQLException ex) {
            ex.printStackTrace(); // In ra lỗi để kiểm tra
        }
        return null;
    }

    public MedicalHistory getMedicalHistory(int id) {
        String sql = "SELECT m.id, m.examination_date, m.diagnosis, m.prescription, o.fullname as doctorName, p.fullname as patientName, s.`name`, s.id as statusId, o.id as doctorId, p.id as patientId FROM medicalhistory m\n"
                + "JOIN doctor o on m.doctor_id = o.id\n"
                + "JOIN patient p on m.patient_id = p.id\n"
                + "JOIN `status` s on s.id = m.status_id\n"
                + "WHERE m.id = ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                MedicalHistory medicalHistory = MedicalHistory.builder()
                        .id(rs.getInt("id"))
                        .examinationDate(rs.getDate("examination_date"))
                        .diagnosis(rs.getString("diagnosis"))
                        .prescription(rs.getString("prescription"))
                        .doctor(Doctor.builder().id(rs.getInt("doctorId")).fullname(rs.getString("doctorName")).build())
                        .patient(Patient.builder().id(rs.getInt("patientId")).fullname(rs.getString("patientName")).build())
                        .status(Status.builder().id(rs.getInt("statusId")).name(rs.getString("name")).build())
                        .build();
                return medicalHistory;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // In ra lỗi để kiểm tra
        }
        return null;
    }

    public List<Status> getAllStatus() {
        List<Status> statuses = new ArrayList<>();
        String sql = "SELECT * FROM status;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Status status = Status.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build();
                statuses.add(status);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return statuses;
    }

    public void updateMedicalHistory(int id, String examinationDate, String diagnosis, String prescription,int patientId, int doctorId, int statusId) {
        try {
            String sql = "UPDATE `medicalhistory` SET `examination_date` = ?, `diagnosis` = ?, `prescription` = ?, `patient_id` = ?, `doctor_id` = ?, `status_id` = ? WHERE (`id` = ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, examinationDate);
            preparedStatement.setString(2, diagnosis);
            preparedStatement.setString(3, prescription);
            preparedStatement.setInt(4, patientId);
            preparedStatement.setInt(5, doctorId);
            preparedStatement.setInt(6, statusId);
            preparedStatement.setInt(7, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
