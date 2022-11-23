/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.GestorFoto;
import Controlador.GestorHabitacion;
import Modelo.Foto;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Cristian
 */
@WebServlet(name = "FotosHabitacionAdmin", urlPatterns = {"/FotosHabitacionAdmin"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5,
        location = "C:\\Users\\pepa_\\Desktop\\Facu\\ResidenciaEstudiantes\\web\\fotos")

public class FotosHabitacionAdmin extends HttpServlet {

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
        GestorHabitacion gh = new GestorHabitacion();
        request.setAttribute("habitacion", gh.getHabitacionById(Integer.parseInt(request.getParameter("id"))));
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/fotosHabitacionAdmin.jsp");
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
        GestorFoto gf = new GestorFoto();
        GestorHabitacion gh = new GestorHabitacion();
        ArrayList<Foto> lista = new ArrayList<>();
        for (Part part : request.getParts()) {
            String fileName = getFileName(part);
            if (!fileName.isEmpty()) {
                part.write(fileName);
                Foto f = new Foto(fileName);
                lista.add(f);
            }
        }
        int idHabitacion = Integer.parseInt(request.getParameter("txtId"));
        gf.insertFotosHabitacion(idHabitacion, lista);
        request.setAttribute("habitacion", gh.getHabitacionById(idHabitacion));
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/fotosHabitacionAdmin.jsp");
        rd.forward(request, response);
    }

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return "";
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
