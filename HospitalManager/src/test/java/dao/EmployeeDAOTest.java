///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
// */
//package dao;
//
//import java.util.List;
//import model.Employee;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author MSI Bravo
// */
//public class EmployeeDAOTest {
//    
//    public EmployeeDAOTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    @Test
//    public void testInsertNewEmployee() {
//        System.out.println("insertNewEmployee");
//        int user_id = 0;
//        String email = "";
//        String first_name = "";
//        String last_name = "";
//        String password = "";
//        boolean status = false;
//        int role = 0;
//        int employee_id = 0;
//        String fullname = "";
//        String dob = "";
//        boolean gender = false;
//        String address = "";
//        String phonenumber = "";
//        EmployeeDAO instance = new EmployeeDAO();
//        int expResult = 0;
//        int result = instance.insertNewEmployee(user_id, email, first_name, last_name, password, status, role, employee_id, fullname, dob, gender, address, phonenumber);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetAllEm() {
//        System.out.println("getAllEm");
//        EmployeeDAO instance = new EmployeeDAO();
//        List<Employee> expResult = null;
//        List<Employee> result = instance.getAllEm();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        EmployeeDAO.main(args);
//        fail("The test case is a prototype.");
//    }
//    
//}
