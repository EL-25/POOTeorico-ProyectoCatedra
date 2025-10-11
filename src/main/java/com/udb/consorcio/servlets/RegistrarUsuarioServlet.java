package com.udb.consorcio.servlets;

import com.udb.consorcio.beans.Usuario;
import com.udb.consorcio.dao.UsuarioDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/registrarUsuario")
public class RegistrarUsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("idUsuario");
        String contrasena = request.getParameter("contrasena");

        if (id == null || contrasena == null || id.trim().isEmpty() || contrasena.trim().isEmpty()) {
            request.setAttribute("mensajeError", "¡Todos los campos son obligatorios!");
            request.getRequestDispatcher("usuario/error.jsp").forward(request, response);
            return;
        }

        Usuario usuario = new Usuario(id.trim(), contrasena.trim());
        UsuarioDAO dao = new UsuarioDAO();

        boolean registrado = dao.insertarUsuario(usuario);

        if (registrado) {
            request.setAttribute("mensajeExito", "¡Usuario registrado exitosamente!");
            request.getRequestDispatcher("usuario/registroExitoso.jsp").forward(request, response);
        } else {
            request.setAttribute("mensajeError", "¡Error al registrar el usuario!");
            request.getRequestDispatcher("usuario/error.jsp").forward(request, response);
        }
    }
}