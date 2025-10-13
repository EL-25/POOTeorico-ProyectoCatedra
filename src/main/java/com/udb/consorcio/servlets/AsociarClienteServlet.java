package com.udb.consorcio.servlets;

import com.udb.consorcio.beans.ClienteInstitucion;
import com.udb.consorcio.dao.ClienteInstitucionDAO;
import com.udb.consorcio.dao.Conexion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet("/AsociarClienteServlet")
public class AsociarClienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        String dui = req.getParameter("idCliente");

        try (Connection con = Conexion.getConnection()) {
            ClienteInstitucionDAO dao = new ClienteInstitucionDAO(con);

            if ("buscar".equals(accion)) {
                int idCliente = dao.obtenerIdClientePorDui(dui);
                String nombre = dao.obtenerNombrePorDui(dui);
                List<String> asociadas = dao.obtenerInstitucionesAsociadas(idCliente);
                List<String> disponibles = dao.obtenerInstitucionesNoAsociadas(idCliente);

                req.setAttribute("idCliente", dui);
                req.setAttribute("nombre", nombre);
                req.setAttribute("institucionesAsociadas", asociadas);
                req.setAttribute("institucionesDisponibles", disponibles);
                req.getRequestDispatcher("/asociar/asociarCliente.jsp").forward(req, resp);

            } else if ("asociar".equals(accion)) {
                String nombre = dao.obtenerNombrePorDui(dui);
                int idCliente = dao.obtenerIdClientePorDui(dui);
                String nombreInstitucion = req.getParameter("idInstitucion");

                if (nombreInstitucion == null || nombreInstitucion.isEmpty()) {
                    req.setAttribute("idCliente", dui);
                    req.setAttribute("nombre", nombre);
                    req.setAttribute("institucionesAsociadas", dao.obtenerInstitucionesAsociadas(idCliente));
                    req.setAttribute("institucionesDisponibles", dao.obtenerInstitucionesNoAsociadas(idCliente));
                    req.setAttribute("accion", "asociar");
                    req.getRequestDispatcher("/asociar/asociarCliente.jsp").forward(req, resp);
                    return;
                }

                int idInstitucion = obtenerIdInstitucionPorNombre(con, nombreInstitucion);
                Date fecha = Date.valueOf(LocalDate.now());

                ClienteInstitucion ci = new ClienteInstitucion(idCliente, idInstitucion, fecha);
                dao.asociarCliente(ci);

                req.setAttribute("idCliente", dui);
                req.setAttribute("nombre", nombre);
                req.setAttribute("institucionesAsociadas", dao.obtenerInstitucionesAsociadas(idCliente));
                req.setAttribute("institucionesDisponibles", dao.obtenerInstitucionesNoAsociadas(idCliente));
                req.getRequestDispatcher("/asociar/asociarCliente.jsp").forward(req, resp);
            }

        } catch (Exception e) {
            req.setAttribute("error", "Error: " + e.getMessage());
            req.getRequestDispatcher("/asociar/errorAsociacion.jsp").forward(req, resp);
        }
    }

    private int obtenerIdInstitucionPorNombre(Connection con, String nombre) throws SQLException {
        String sql = "SELECT id_institucion FROM institucion WHERE nombre = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, nombre);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) return rs.getInt("id_institucion");
        }
        return -1;
    }
}
