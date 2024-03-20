/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.swd.hospitalmanager.controllers;

import dao.PatientDAO;
import dao.UserDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import model.User;

/**
 *
 * @author FPT SHOP
 */
public class PatientRegisterController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            PatientDAO dao = new PatientDAO();
            String submit = request.getParameter("submit");
            if (submit == null) {
                RequestDispatcher disp = request.getRequestDispatcher("/PatientRegister.jsp");
                disp.forward(request, response);
            } else {
                int user_id = 0;
                String email = request.getParameter("email");
                String first_name = request.getParameter("first_name");
                String last_name = request.getParameter("last_name");
                String password = request.getParameter("password");
                boolean status = true;
                int role = 3;
                int patient_id = 0;
                String fullname = request.getParameter("fullname");
                //Date formatter
                String dobString = request.getParameter("dob");
                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate dobDate = LocalDate.parse(dobString, inputFormatter);
                LocalDate dateNow = LocalDate.now();
                String dobFormatted = dobDate.format(inputFormatter);
                String dateNowFormatted = dateNow.format(inputFormatter);
                //
                boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
                String address = request.getParameter("address");
                String phonenumber = request.getParameter("phonenumber");

                //check if field empty
                if (email == null || first_name == null || last_name == null || password == null || fullname == null || dobString == null || address == null || phonenumber == null) {
                    request.setAttribute("messError", "Field can not empty");
                    request.getRequestDispatcher("/PatientRegister.jsp").forward(request, response);
                } else if(dobDate.isAfter(dateNow)) {
                    request.setAttribute("messError", "Date of birth is not valid");
                    request.getRequestDispatcher("/PatientRegister.jsp").forward(request, response);
                }
                UserDAO userDAO = new UserDAO();
                User user = userDAO.getUserByEmailAndPass(email, password);
                if (user == null) {
                    int n = dao.insertNewPatient(user_id, email, first_name, last_name, password, status, role, patient_id, fullname, dobFormatted, gender, address, phonenumber);
                    if (n > 0) {

                        HttpSession session = request.getSession();
                        response.sendRedirect("/index.html");
                    } else {
                        out.print("failed");
                    }
                } else {
                    request.setAttribute("messError", "User Existed");
                    request.getRequestDispatcher("/PatientRegister.jsp").forward(request, response);
                }

            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
