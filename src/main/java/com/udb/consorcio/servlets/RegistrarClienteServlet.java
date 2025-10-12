package com.udb.consorcio.servlets;

import com.udb.consorcio.beans.Cliente;
import com.udb.consorcio.dao.ClienteDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/RegistrarClienteServlet")
public class RegistrarClienteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String dui = request.getParameter("dui");
        String nombre = request.getParameter("nombre");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        String genero = request.getParameter("genero");
        String departamento = request.getParameter("departamento");
        String municipio = request.getParameter("municipio");
        String complemento = request.getParameter("complemento");
        String idInstitucionStr = request.getParameter("idInstitucion");

        // Validación básica
        if (dui == null || nombre == null || fechaNacimiento == null || genero == null ||
                departamento == null || municipio == null || idInstitucionStr == null ||
                dui.isEmpty() || nombre.isEmpty() || fechaNacimiento.isEmpty() || genero.isEmpty() ||
                departamento.isEmpty() || municipio.isEmpty() || idInstitucionStr.isEmpty()) {

            response.sendRedirect("cliente/errorCliente.jsp?error=campos");
            return;
        }

        // Validación de formato DUI
        if (!dui.matches("\\d{8}-\\d")) {
            response.sendRedirect("cliente/errorCliente.jsp?error=formato");
            return;
        }

        try {
            int idInstitucion = Integer.parseInt(idInstitucionStr);

            // Verificar si el cliente ya existe
            ClienteDAO dao = new ClienteDAO();
            boolean existe = dao.existeCliente(dui);

            if (existe) {
                // Verificar si ya está asociado
                boolean yaAsociado = dao.clienteYaAsociado(dui);
                if (yaAsociado) {
                    request.setAttribute("mensajeError", "Cliente ya está asociado a una institución.");
                    request.getRequestDispatcher("cliente/errorCliente.jsp").forward(request, response);
                    return;
                } else {
                    request.setAttribute("mensajeInfo", "Cliente: no se relaciona con institución.");
                    request.getRequestDispatcher("cliente/errorCliente.jsp").forward(request, response);
                    return;
                }
            }

            // Si no existe, registrar cliente normalmente
            Cliente cliente = new Cliente(dui, nombre, fechaNacimiento, genero,
                    departamento, municipio, complemento, idInstitucion);

            boolean registrado = dao.insertarCliente(cliente);

            if (registrado) {
                response.sendRedirect("cliente/registroExitosoCliente.jsp");
            } else {
                response.sendRedirect("cliente/errorCliente.jsp?error=falloRegistro");
            }

        } catch (NumberFormatException e) {
            response.sendRedirect("cliente/errorCliente.jsp?error=formato");
        } catch (Exception e) {
            request.setAttribute("mensajeError", "Error inesperado: " + e.getMessage());
            request.getRequestDispatcher("cliente/errorCliente.jsp").forward(request, response);
        }
    }
}