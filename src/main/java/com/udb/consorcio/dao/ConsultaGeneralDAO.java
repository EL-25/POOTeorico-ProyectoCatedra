package com.udb.consorcio.dao;

import com.udb.consorcio.beans.Consorcio;
import com.udb.consorcio.beans.Institucion;
import com.udb.consorcio.beans.Cliente;

import java.sql.*;

public class ConsultaGeneralDAO {
    private final Connection con;

    public ConsultaGeneralDAO(Connection con) {
        this.con = con;
    }

    // Buscar Consorcio por ID
    public Consorcio buscarConsorcioPorId(String id) {
        String sql = "SELECT id_consorcio, nombre, fecha_registro FROM consorcio WHERE id_consorcio = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Consorcio c = new Consorcio();
                c.setIdConsorcio(rs.getString("id_consorcio"));
                c.setNombreConsorcio(rs.getString("nombre"));
                c.setFechaRegistro(rs.getDate("fecha_registro").toLocalDate());
                return c;
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar consorcio: " + e.getMessage());
        }
        return null;
    }

    //  Buscar Institución por ID
    public Institucion buscarInstitucionPorId(String id) {
        String sql = "SELECT id_institucion, nombre, tipo, fecha_fundacion, id_consorcio FROM institucion WHERE id_institucion = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Institucion i = new Institucion();
                i.setIdInstitucion(rs.getString("id_institucion"));
                i.setNombre(rs.getString("nombre"));
                i.setTipo(rs.getString("tipo"));
                i.setFechaFundacion(rs.getDate("fecha_fundacion").toLocalDate());
                i.setIdConcorcio(rs.getString("id_consorcio")); // respetando tu bean original
                return i;
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar institución: " + e.getMessage());
        }
        return null;
    }

    //  Buscar Cliente por ID
    public Cliente buscarClientePorId(String id) {
        String sql = "SELECT * FROM cliente WHERE id_cliente = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("id_cliente"));
                c.setDui(rs.getString("dui"));
                c.setNombre(rs.getString("nombre"));
                c.setFechaNacimiento(rs.getDate("fecha_nacimiento").toString());
                c.setGenero(rs.getString("genero"));
                c.setDepartamento(rs.getString("departamento"));
                c.setMunicipio(rs.getString("municipio"));
                c.setComplemento(rs.getString("complemento"));
                c.setIdInstitucion(rs.getInt("id_institucion"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar cliente por ID: " + e.getMessage());
        }
        return null;
    }

    // Buscar Cliente por DUI
    public Cliente buscarClientePorDui(String dui) {
        String sql = "SELECT * FROM cliente WHERE dui = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, dui);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("id_cliente"));
                c.setDui(rs.getString("dui"));
                c.setNombre(rs.getString("nombre"));
                c.setFechaNacimiento(rs.getDate("fecha_nacimiento").toString());
                c.setGenero(rs.getString("genero"));
                c.setDepartamento(rs.getString("departamento"));
                c.setMunicipio(rs.getString("municipio"));
                c.setComplemento(rs.getString("complemento"));
                c.setIdInstitucion(rs.getInt("id_institucion"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar cliente por DUI: " + e.getMessage());
        }
        return null;
    }
}
