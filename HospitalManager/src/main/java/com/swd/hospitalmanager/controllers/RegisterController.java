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
public class RegisterController extends HttpServlet {

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
            String submit = request.getParameter("submit");
            if (submit == null) {
                request.getRequestDispatcher("/Register.jsp").forward(request, response);
            } else {
                String email = request.getParameter("email");
                String firstname = request.getParameter("firstname");
                String lastname = request.getParameter("lastname");
                String password = request.getParameter("password");
                boolean status = true;
                int role = Integer.parseInt(request.getParameter("role"));

                //check if field empty
                if (firstname == null || lastname == null || password == null) {
                    request.setAttribute("messError", "Field can not empty");
                    request.getRequestDispatcher("/Register.jsp").forward(request, response);
                }

                UserDAO dao = new UserDAO();
                User user = dao.getUserByEmailAndPass(email, password);

                if (user == null) {
                    dao.InsertNewUser(role, email, firstname, lastname, password, status, role);
                    HttpSession session = request.getSession();
                    response.sendRedirect("Login");
                } else {
                    request.setAttribute("messError", "User Exist");
                    request.getRequestDispatcher("/Register.jsp").forward(request, response);
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
