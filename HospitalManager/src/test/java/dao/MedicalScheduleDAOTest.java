/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import java.util.List;
import model.MedicalHistory;
import model.Status;
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
public class MedicalScheduleDAOTest {
    
    public MedicalScheduleDAOTest() {
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
     * Test of getAllMedicalHistory method, of class MedicalScheduleDAO.
     */
    @Test
    public void testGetAllMedicalHistory() {
        System.out.println("getAllMedicalHistory");
        MedicalScheduleDAO instance = new MedicalScheduleDAO();
        List<MedicalHistory> expResult = null;
        List<MedicalHistory> result = instance.getAllMedicalHistory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMedicalHistory method, of class MedicalScheduleDAO.
     */
    @Test
    public void testGetMedicalHistory() {
        System.out.println("getMedicalHistory");
        int id = 0;
        MedicalScheduleDAO instance = new MedicalScheduleDAO();
        MedicalHistory expResult = null;
        MedicalHistory result = instance.getMedicalHistory(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllStatus method, of class MedicalScheduleDAO.
     */
    @Test
    public void testGetAllStatus() {
        System.out.println("getAllStatus");
        MedicalScheduleDAO instance = new MedicalScheduleDAO();
        List<Status> expResult = null;
        List<Status> result = instance.getAllStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
