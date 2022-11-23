/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.GestorAlquiler;
import Controlador.GestorDetalleAlquiler;
import Controlador.GestorPago;
import Modelo.Alquiler;
import Modelo.DetalleAlquiler;
import Modelo.Pago;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
@WebServlet(name = "AgregarPagoAdmin", urlPatterns = {"/AgregarPagoAdmin"})
public class AgregarPagoAdmin extends HttpServlet {

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
        GestorDetalleAlquiler gda = new GestorDetalleAlquiler();
        GestorAlquiler ga = new GestorAlquiler();
        ArrayList<Alquiler> listaAlquileresSinPago = new ArrayList<>();
        Alquiler a;
        for (Object x : gda.listaSinPago()) {
            DetalleAlquiler da = (DetalleAlquiler) x;
            a = ga.getAlquilerById(da.getAlquiler().getId());
            listaAlquileresSinPago.add(a);
        }
        request.setAttribute("listaAlquileresSinPago", listaAlquileresSinPago);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/agregarPagoAdmin.jsp");
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
        if (request.getSession().getAttribute("usuario") == null) {
            response.sendRedirect("/ResidenciaEstudiantes/Login");
            return;
        }
        try {
            Alquiler a = new GestorAlquiler().getAlquilerById(Integer.parseInt(request.getParameter("idAlquiler")));
            Pago p = new Pago(new Date());
            a.setPago(p);
            GestorPago gp = new GestorPago();
            gp.insert(p, a);
            response.sendRedirect("/ResidenciaEstudiantes/ListaAlquileresAdmin");
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
