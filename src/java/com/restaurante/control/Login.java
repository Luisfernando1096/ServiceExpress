/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.restaurante.control;

import com.restaurante.conexion.Conexion;
import com.restaurante.conexion.ConexionPool;
import com.restaurante.entidades.Comandos;
import com.restaurante.entidades.Usuarios;
import com.restaurante.operaciones.Operaciones;
import com.restaurante.utilerias.Hash;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author fruiz
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion == null) {

            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (accion.equals("login")) {
            try {
                iniciarSesion(request, response);
            } catch (SQLException e) {

            }
        }
    }

    private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String pinCode = request.getParameter("clave");
        PrintWriter io = response.getWriter();HttpSession sesion = request.getSession();
        if (pinCode == null) {
            pinCode = "";
        }

        try {
            Conexion cn = new ConexionPool();
            cn.conectar();
            Operaciones.abrirConexion(cn);
            Operaciones.iniciarTransaccion();
            List<Usuarios> u = getUsuario(pinCode);

            if (cn.getConexion() == null) {
                request.setAttribute("error", 1);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                if (!u.isEmpty()) {

// == Integer.parseInt(Hash.generarHash(pinCode, Hash.SHA256))
                    //sesion.setAttribute("Usuario", u.getUsuario());
                    //sesion.setAttribute("Nombres", u.getNombres());
                    //sesion.setAttribute("Apellidos", u.getApellidos());
                    List<Comandos> permisos = getPermisos(u.get(0).getIdRol());
                    sesion.setAttribute("MenuPrincipal", permisos);
                    sesion.setAttribute("Rol", u.get(0).getIdRol());
                    sesion.setAttribute("Usuario", u.get(0).getIdUsuario());
                    response.sendRedirect("Principal");
                } else {

                    request.setAttribute("error", 2);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            }
            Operaciones.commit();
        } catch (Exception e) {
            Operaciones.rollback();
            io.print(e);
        } finally {
            try {
                Operaciones.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    private List<Comandos> getPermisos(int idrol) throws SQLException {

        List<Comandos> comandos = new ArrayList();
        try {
            String sql = "select * from comando where idComando in (select idComando from permiso where idRol = ?)";
            List<Object> parametros = new ArrayList();
            parametros.add(idrol);
            String[][] rs = Operaciones.consultar(sql, parametros);
            for (int i = 0; i < rs[0].length; i++) {
                Comandos m = new Comandos(Integer.parseInt(rs[0][i]), rs[1][i]);
                comandos.add(m);

            }
        } catch (Exception e) {
            Operaciones.rollback();
        }
        return comandos;
    }
    private List<Usuarios> getUsuario(String pin) throws SQLException {

        List<Usuarios> u = new ArrayList();
        try {
            String sql = "select * from usuario where pinCode = md5(?);";
            List<Object> parametros = new ArrayList();
            parametros.add(pin);
            String[][] rs = Operaciones.consultar(sql, parametros);
            for (int i = 0; i < rs[0].length; i++) {
                Usuarios m = new Usuarios(Integer.parseInt(rs[0][i]), Integer.parseInt(rs[1][i]), rs[2][i]);
                u.add(m);

            }
        } catch (Exception e) {
            Operaciones.rollback();
        }
        return u;
    }

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
