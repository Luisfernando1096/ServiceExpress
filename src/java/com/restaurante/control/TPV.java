package com.restaurante.control;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author fruiz
 */
@WebServlet(name = "TPV", urlPatterns = {"/TPV"})
public class TPV extends HttpServlet {

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
            request.setAttribute("tpv", "active border");//Marcar una celda activa
            request.getRequestDispatcher("tpv.jsp").forward(request, response);
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
