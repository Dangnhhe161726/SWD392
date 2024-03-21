/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import java.util.List;
import model.Doctor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Windows 11
 */
public class DoctorDAOTest {
    
    public DoctorDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insertNewDoctor method, of class DoctorDAO.
     */
    @Test
    public void testInsertNewDoctor() {
        System.out.println("insertNewDoctor");
        int user_id = 0;
        String email = "";
        String first_name = "";
        String last_name = "";
        String password = "";
        boolean status = false;
        int role = 0;
        int doctor_id = 0;
        String fullname = "";
        String dob = "";
        boolean gender = false;
        String address = "";
        String specialization = "";
        String qualification = "";
        String phonenumber = "";
        DoctorDAO instance = new DoctorDAO();
        int expResult = 0;
        int result = instance.insertNewDoctor(user_id, email, first_name, last_name, password, status, role, doctor_id, fullname, dob, gender, address, specialization, qualification, phonenumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllDoctor method, of class DoctorDAO.
     */
    @Test
    public void testGetAllDoctor() {
        System.out.println("getAllDoctor");
        DoctorDAO instance = new DoctorDAO();
        List<Doctor> expResult = null;
        List<Doctor> result = instance.getAllDoctor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
