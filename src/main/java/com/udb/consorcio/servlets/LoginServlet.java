package com.udb.consorcio.servlets;

import com.udb.consorcio.dao.UsuarioDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("idUsuario");
        String contrasena = request.getParameter("contrasena");

        if (id == null || contrasena == null || id.trim().isEmpty() || contrasena.trim().isEmpty()) {
            request.setAttribute("mensajeError", "¡Usuario o contraseña vacíos!");
            request.getRequestDispatcher("usuario/error.jsp").forward(request, response);
            return;
        }

        UsuarioDAO dao = new UsuarioDAO();
        boolean valido = dao.validarUsuario(id.trim(), contrasena.trim());

        if (valido) {
            request.setAttribute("usuarioAutenticado", id.trim());
            request.getRequestDispatcher("menu.jsp").forward(request, response);
        } else {
            request.setAttribute("mensajeError", "¡Credenciales incorrectas!");
            request.getRequestDispatcher("usuario/error.jsp").forward(request, response);
        }
    }
}