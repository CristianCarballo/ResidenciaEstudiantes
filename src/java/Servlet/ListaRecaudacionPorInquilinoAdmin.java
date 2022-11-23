/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.GestorInquilino;
import Controlador.GestorPago;
import Modelo.Inquilino;
import Modelo.ViewRecaudacionInquilino;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "ListaRecaudacionPorInquilinoAdmin", urlPatterns = {"/ListaRecaudacionPorInquilinoAdmin"})
public class ListaRecaudacionPorInquilinoAdmin extends HttpServlet {

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
        GestorInquilino gi = new GestorInquilino();
        GestorPago gp = new GestorPago();
        ArrayList<ViewRecaudacionInquilino> lista = new ArrayList<>();
        for (Object x : gi.listar()) {
            Inquilino i = (Inquilino)x;
            float total = gp.getRecaudacionPorInquilino(i.getId());
            ViewRecaudacionInquilino vri = new ViewRecaudacionInquilino(i.getId(), i.getNombre(), i.getApellido(), total);
            lista.add(vri);
        }
        request.setAttribute("listaRecaudacionInquilino", lista);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaRecaudacionPorInquilinoAdmin.jsp");
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
