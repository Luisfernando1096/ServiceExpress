/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.restaurante.control;

import com.restaurante.entidades.Comandos;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author fruiz
 */
@WebServlet(name = "Principal", urlPatterns = {"/Principal"})
public class Principal extends HttpServlet {
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // String op = request.getParameter("op");
        HttpSession s = request.getSession();
        String accion = request.getParameter("accion");
        if (accion == null) {

            //Redirecciona donde quiero al no estar logueado
            if (s.getAttribute("Usuario") == null) {
                request.getRequestDispatcher("Login").forward(request, response);
            }
            

            request.getRequestDispatcher("principal.jsp").forward(request, response);
            //Controlar los permisos
            //com.restaurante.utilerias.Permiso.getPermiso(s, "principal.jsp", request, response, op);
            //request.setAttribute("op", op);
        } else if (accion.equals("logout")) {
            logout(request, response);
        }

    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sesion = request.getSession();
        //sesion.removeAttribute("Usuario");
        //sesion.removeAttribute("Nombre");
        sesion.removeAttribute("Rol");
        sesion.invalidate();
        response.sendRedirect("Login");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
