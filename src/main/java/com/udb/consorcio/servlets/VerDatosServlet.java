package com.udb.consorcio.servlets;

import com.udb.consorcio.beans.DatosGuardados;
import com.udb.consorcio.beans.Consorcio;
import com.udb.consorcio.beans.Institucion;
import com.udb.consorcio.beans.Cliente;
import com.udb.consorcio.dao.ConsultaGeneralDAO;
import com.udb.consorcio.dao.Conexion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/VerDatosServlet")
public class VerDatosServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tipo = req.getParameter("tipo");
        String valor = req.getParameter("id"); // puede ser ID o DUI según el tipo

        if (tipo == null || tipo.isBlank() || valor == null || valor.isBlank()) {
            req.setAttribute("error", "Debe seleccionar un tipo y proporcionar un valor.");
            req.getRequestDispatcher("/ver/errorConsulta.jsp").forward(req, resp);
            return;
        }

        DatosGuardados datos = new DatosGuardados();

        try (Connection con = Conexion.getConnection()) {
            ConsultaGeneralDAO dao = new ConsultaGeneralDAO(con);

            switch (tipo) {
                case "consorcio" -> {
                    Consorcio c = dao.buscarConsorcioPorId(valor);
                    if (c != null) {
                        datos.setIdConsorcio(c.getIdConsorcio());
                        datos.setNombreConsorcio(c.getNombreConsorcio());
                        datos.setFechaRegistro(c.getFechaRegistro());
                    }
                }
                case "institucion" -> {
                    Institucion i = dao.buscarInstitucionPorId(valor);
                    if (i != null) {
                        datos.setIdInstitucion(i.getIdInstitucion());
                        datos.setNombreInstitucion(i.getNombre());
                        datos.setTipoInstitucion(i.getTipo());
                        datos.setFechaFundacion(i.getFechaFundacion());
                        datos.setPerteneceConsorcio(i.getIdConcorcio());
                    }
                }
                case "cliente" -> {
                    Cliente cl = dao.buscarClientePorDui(valor);
                    if (cl != null) {
                        datos.setIdCliente(cl.getIdCliente());
                        datos.setDui(cl.getDui());
                        datos.setNombreCliente(cl.getNombre());
                        datos.setFechaNacimiento(cl.getFechaNacimiento());
                        datos.setGenero(cl.getGenero());
                        datos.setDepartamento(cl.getDepartamento());
                        datos.setMunicipio(cl.getMunicipio());
                        datos.setComplemento(cl.getComplemento());
                    }
                }

            }

            boolean sinDatos =
                    ("consorcio".equals(tipo) && datos.getIdConsorcio() == null) ||
                            ("institucion".equals(tipo) && datos.getIdInstitucion() == null) ||
                            ("cliente".equals(tipo) && datos.getIdCliente() == 0);

            if (sinDatos) {
                req.setAttribute("error", "No se encontró ningún registro con ese valor.");
                req.getRequestDispatcher("/ver/errorConsulta.jsp").forward(req, resp);
                return;
            }

            req.setAttribute("datos", datos);
            req.setAttribute("tipo", tipo);
            req.getRequestDispatcher("/ver/verDatosGuardados.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error al consultar: " + e.getMessage());
            req.getRequestDispatcher("/ver/errorConsulta.jsp").forward(req, resp);
        }
    }
}
