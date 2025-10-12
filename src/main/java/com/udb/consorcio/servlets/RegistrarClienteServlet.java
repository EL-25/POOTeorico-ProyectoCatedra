package com.udb.consorcio.servlets;

import com.udb.consorcio.beans.Cliente;
import com.udb.consorcio.dao.ClienteDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

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

            Cliente cliente = new Cliente(dui, nombre, fechaNacimiento, genero,
                    departamento, municipio, complemento, idInstitucion);

            ClienteDAO dao = new ClienteDAO();
            boolean registrado = dao.insertarCliente(cliente);

            if (registrado) {
                response.sendRedirect("cliente/registroExitosoCliente.jsp");
            } else {
                response.sendRedirect("cliente/errorCliente.jsp?error=duplicado");
            }

        } catch (NumberFormatException e) {
            response.sendRedirect("cliente/errorCliente.jsp?error=formato");
        }
    }
}