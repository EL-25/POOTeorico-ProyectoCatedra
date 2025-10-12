package com.udb.consorcio.servlets;

import com.udb.consorcio.beans.Institucion;
import com.udb.consorcio.dao.InstitucionDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/registrarInstitucion")
public class RegistrarInstitucionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String tipo = request.getParameter("tipo");
        String fechaFundacion = request.getParameter("fechaFundacion");
        String idConcorcio = request.getParameter("idConcorcio");

        if (esVacio(nombre) || esVacio(tipo) || esVacio(fechaFundacion) || esVacio(idConcorcio)) {
            request.setAttribute("mensajeError", "campos");
            request.getRequestDispatcher("institucion/errorInstitucion.jsp").forward(request, response);
            return;
        }

        // Validación de fecha (opcional, si querés detectar formato inválido)
        if (!fechaFundacion.matches("\\d{4}-\\d{2}-\\d{2}")) {
            request.setAttribute("mensajeError", "fecha");
            request.getRequestDispatcher("institucion/errorInstitucion.jsp").forward(request, response);
            return;
        }

        Institucion institucion = new Institucion(
                nombre.trim(),
                tipo.trim(),
                fechaFundacion.trim(),
                idConcorcio.trim()
        );

        InstitucionDAO dao = new InstitucionDAO();
        boolean registrado = dao.insertarInstitucion(institucion);

        if (registrado) {
            request.setAttribute("mensajeExito", "REGISTRO COMPLETADO CON ¡ÉXITO!");
            request.getRequestDispatcher("institucion/registroExitosoInstitucion.jsp").forward(request, response);
        } else {
            request.setAttribute("mensajeError", "duplicado");
            request.getRequestDispatcher("institucion/errorInstitucion.jsp").forward(request, response);
        }
    }

    private boolean esVacio(String valor) {
        return valor == null || valor.trim().isEmpty();
    }
}