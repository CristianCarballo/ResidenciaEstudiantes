/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.GestorHabitacion;
import Controlador.GestorUsuario;
import Modelo.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Cristian
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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

        String accion = request.getParameter("accion");

        if (accion != null && accion.equals("cerrar")) {
            HttpSession sesion = request.getSession();
            sesion.removeAttribute("usuario");
            sesion.invalidate();
            GestorHabitacion gh = new GestorHabitacion();
            request.setAttribute("habitacion", gh.getHabitacionMenorPrecio());
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/loginError.jsp");
            rd.forward(request, response);
        }

        if (accion != null && accion.equals("ingresar")) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
        rd.forward(request, response);
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
        String email = request.getParameter("txtUsuario");
        String contraseña = request.getParameter("txtPass");
        Usuario usuario = new Usuario(email, contraseña);
        GestorUsuario gu = new GestorUsuario();
        if (gu.existe(usuario)) {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("usuario", usuario);
            sesion.setMaxInactiveInterval(600);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/menuAdministracion.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/loginError.jsp");
            rd.forward(request, response);
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
