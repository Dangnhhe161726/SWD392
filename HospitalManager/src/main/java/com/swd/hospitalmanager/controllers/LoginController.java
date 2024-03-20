/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.swd.hospitalmanager.controllers;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author FPT SHOP
 */
public class LoginController extends HttpServlet {

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
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            //luu seesion
            HttpSession session = request.getSession();

            UserDAO dao = new UserDAO();
            User user = dao.getUserByEmailAndPass(email, password);
            //get user by email and pass if user not exist, display message
            //if user exist direct user to page based on role
            if (user == null) {
                request.setAttribute("errorMessage", "Account Information invalid, try again");
                request.getRequestDispatcher("/Login.jsp").forward(request, response);
            } else {
                switch (user.getRole()) {
                    case 1:
                        session.setAttribute("user", user);
                        response.sendRedirect(request.getContextPath() + "/DoctorHome");
                        break;
                    case 2:
                        session.setAttribute("user", user);
                        response.sendRedirect(request.getContextPath() + "/listpatient"); //Employee Home
                        break;
                    case 3:
                        session.setAttribute("user", user);
                        response.sendRedirect(request.getContextPath() + "/PatientHome");
                        break;
                    case 4:
                        session.setAttribute("user", user);
                        response.sendRedirect(request.getContextPath() + "/AdminHome");
                        break;
                    default:
                        break;
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
        request.getRequestDispatcher("/Login.jsp").forward(request, response);
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
