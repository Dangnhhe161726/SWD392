/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.swd.hospitalmanager.controllers;

import dao.DoctorDAO;
import dao.MedicalScheduleDAO;
import dao.PatientDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Doctor;
import model.Patient;
import model.Status;

/**
 *
 * @author Windows 11
 */
public class EditMedicalHistory extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditMedicalHistory</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditMedicalHistory at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        MedicalScheduleDAO dao = new MedicalScheduleDAO();
        PatientDAO patientDAO = new PatientDAO();
        DoctorDAO doctorDAO = new DoctorDAO();
        String id_row = request.getParameter("id");
        response.getWriter().print(id_row);
        try {
            int id = Integer.parseInt(id_row);
            List<Patient> patients = patientDAO.getallPatient();
            List<Doctor> doctors = doctorDAO.getAllDoctor();
            List<Status> statuses = dao.getAllStatus();
            model.MedicalHistory medicalHistory = dao.getMedicalHistory(id);
            if (medicalHistory != null) {
                request.setAttribute("m", medicalHistory);
                request.setAttribute("listD", doctors);
                request.setAttribute("listP", patients);
                request.setAttribute("listS", statuses);
            } else {
                throw new Exception();
            }
            request.getRequestDispatcher("EditMedicalHistory.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("./medicalhistory");
        }
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
        try {
            MedicalScheduleDAO dao = new MedicalScheduleDAO();
            String idMedicalHistory = request.getParameter("id");
            int id = Integer.parseInt(idMedicalHistory);
            String examinationDate = request.getParameter("examinationDate");
            String diagnosis = request.getParameter("diagnosis");
            String prescription = request.getParameter("prescription");
            String patient = request.getParameter("patient");
            int patientId = Integer.parseInt(patient);
            String doctor = request.getParameter("doctor");
            int doctorId = Integer.parseInt(doctor);
            String status = request.getParameter("status");
            int statusId = Integer.parseInt(status);

            dao.updateMedicalHistory(id, examinationDate, diagnosis, prescription, patientId, doctorId, statusId);
            response.sendRedirect("./editmedicalhistory?id=" + id);
        } catch (Exception e) {
            response.sendRedirect("./medicalhistory");
        }
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
