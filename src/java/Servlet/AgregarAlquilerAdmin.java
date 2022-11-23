/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.GestorAlquiler;
import Controlador.GestorHabitacion;
import Controlador.GestorInquilino;
import Modelo.Alquiler;
import Modelo.DetalleAlquiler;
import Modelo.Habitacion;
import Modelo.Inquilino;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alumno
 */
@WebServlet(name = "AgregarAlquilerAdmin", urlPatterns = {"/AgregarAlquilerAdmin"})
public class AgregarAlquilerAdmin extends HttpServlet {

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
        GestorInquilino gi = new GestorInquilino();
        GestorHabitacion gh = new GestorHabitacion();
        request.setAttribute("listaInquilinosNoAlojados", gi.listarNoAlojados());
        ArrayList<Habitacion> listaHabitacionesDisponibles = new ArrayList<>();
        for (Object x : gh.listar()) {
            Habitacion habitacion = (Habitacion) x;
            if (habitacion != null && habitacion.getDisponibilidad() > 0) {
                listaHabitacionesDisponibles.add(habitacion);
            }
        }
        request.setAttribute("listaHabitacionesDisponibles", listaHabitacionesDisponibles);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/agregarAlquilerAdmin.jsp");
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
            Inquilino i = new GestorInquilino().getInquilinoById(Integer.parseInt(request.getParameter("idInquilino")));
            Habitacion h = new GestorHabitacion().getHabitacionById(Integer.parseInt(request.getParameter("idHabitacion")));
            String fechaIngresoCadena = request.getParameter("dtpFechaIngreso");
            String fechaSalidaCadena = request.getParameter("dtpFechaSalida");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaIngreso = sdf.parse(fechaIngresoCadena);
            Date fechaSalida = sdf.parse(fechaSalidaCadena);
            GestorAlquiler ga = new GestorAlquiler();
            int cantidadDias = ga.cantidadDias(fechaIngreso, fechaSalida);
            float precioAlquiler = cantidadDias * h.getPrecioPorDia();
            Alquiler a = new Alquiler(h, fechaIngreso, precioAlquiler);
            DetalleAlquiler da = new DetalleAlquiler(a, i, fechaIngreso, fechaSalida);
            ga.insert(a, da);
            response.sendRedirect("/ResidenciaEstudiantes/AgregarPagoAdmin");
        } catch (NumberFormatException ex) {
            System.out.println(ex);
        } catch (ParseException ex) {
            Logger.getLogger(AgregarAlquilerAdmin.class.getName()).log(Level.SEVERE, null, ex);
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
