package com.udb.consorcio.servlets;

import com.udb.consorcio.beans.Consorcio;
import com.udb.consorcio.dao.ConsorcioDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/registrarConsorcio")
public class RegistrarConsorcioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("idConsorcio");
        String nombre = request.getParameter("nombreConsorcio");

        if (id == null || id.trim().isEmpty() || nombre == null || nombre.trim().isEmpty()) {
            request.setAttribute("mensajeError", "¡DATOS INVÁLIDOS O CAMPOS VACÍOS!");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }

        Consorcio consorcio = new Consorcio(id.trim(), nombre.trim(), LocalDate.now());
        ConsorcioDAO dao = new ConsorcioDAO();

        boolean registrado = dao.insertarConsorcio(consorcio);

        if (registrado) {
            request.setAttribute("mensajeExito", "REGISTRO COMPLETADO CON ¡ÉXITO!");
            request.getRequestDispatcher("consorcio/registroExitoso.jsp").forward(request, response);
        } else {
            request.setAttribute("mensajeError", "¡ESTE CONSORCIO YA EXISTE O HUBO UN ERROR!");
            request.getRequestDispatcher("consorcio/error.jsp").forward(request, response);
        }
    }
}