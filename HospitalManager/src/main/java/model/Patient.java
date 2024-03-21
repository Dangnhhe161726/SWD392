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
 * @author FPT SHOP
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {
    private int id;
    private String fullname;
    private Date dob;
    private boolean gender;
    private String address;
    private String phonenumber;
    private int user_id;
}
