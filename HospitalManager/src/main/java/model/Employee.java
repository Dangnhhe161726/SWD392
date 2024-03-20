/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author FPT SHOP
 */
public class Employee {
    private int id;
    private String fullname;
    private String dob;
    private boolean gender;
    private String address;
    private String phonenumber;
    private int user_id;

    public Employee() {
    }

    public Employee(int id, String fullname, String dob, boolean gender, String address, String phonenumber, int user_id) {
        this.id = id;
        this.fullname = fullname;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.phonenumber = phonenumber;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    @Override
public String toString() {
    return "Employee{" +
            "id=" + id +
            ", fullname='" + fullname + '\'' +
            ", dob=" + dob +
            ", gender=" + gender +
            ", address='" + address + '\'' +
            ", phonenumber='" + phonenumber + '\'' +
            ", user_id=" + user_id +
            '}';}
}
