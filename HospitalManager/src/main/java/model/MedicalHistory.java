/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Windows 11
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class MedicalHistory {
    private int id;
    private Date examinationDate;
    private String diagnosis;
    private String prescription;
    private Patient patient;
    private Doctor doctor;
    private Status status;
}
