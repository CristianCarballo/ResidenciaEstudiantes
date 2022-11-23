/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.GestorInquilino;
import Modelo.Inquilino;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cristian
 */
@WebServlet(name = "AgregarInquilinoAdmin", urlPatterns = {"/AgregarInquilinoAdmin"})
public class AgregarInquilinoAdmin extends HttpServlet {

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
        if (request.getSession().getAttribute("usuario") == null) {
            response.sendRedirect("/ResidenciaEstudiantes/Login");
            return;
        }
        try {
            if (request.getParameter("id") == null) {
                response.sendRedirect("/ResidenciaEstudiantes/agregarInquilinoAdmin.jsp");
            } else {
                int id = Integer.parseInt(request.getParameter("id"));
                GestorInquilino gi = new GestorInquilino();
                request.setAttribute("inquilino", gi.getInquilinoById(id));
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/agregarInquilinoAdmin.jsp");
                rd.forward(request, response);
            }
        } catch (IOException | NumberFormatException | ServletException ex) {
            System.out.println(ex);
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
        if (request.getSession().getAttribute("usuario") == null) {
            response.sendRedirect("/ResidenciaEstudiantes/Login");
            return;
        }
        try {
            int id;
            if (request.getParameter("txtId").equals("")) {
                id = -1;
            } else {
                id = Integer.parseInt(request.getParameter("txtId"));
            }
            String nombre = request.getParameter("txtNombre");
            String apellido = request.getParameter("txtApellido");
            String dni = request.getParameter("txtDni");
            String domicilio = request.getParameter("txtDomicilio");
            String telefono = request.getParameter("txtTelefono");
            Inquilino i = new Inquilino(id, nombre, apellido, dni, domicilio, telefono);
            GestorInquilino gi = new GestorInquilino();
            if (id == -1) {
                gi.insert(i);
                response.sendRedirect("/ResidenciaEstudiantes/AgregarAlquilerAdmin");
            } else {
                gi.update(i);
                response.sendRedirect("/ResidenciaEstudiantes/ListaInquilinosAdmin");
            }
        } catch (IOException | NumberFormatException ex) {
            System.out.println(ex);
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
