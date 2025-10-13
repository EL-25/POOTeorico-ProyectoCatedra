package com.udb.consorcio.dao;

import com.udb.consorcio.beans.ClienteInstitucion;
import java.sql.*;
import java.util.*;

public class ClienteInstitucionDAO {
    private final Connection con;

    public ClienteInstitucionDAO(Connection con) {
        this.con = con;
    }

    //  Asociar cliente a institución (evita duplicados)
    public boolean asociarCliente(ClienteInstitucion ci) throws SQLException {
        String sql = "SELECT COUNT(*) FROM cliente_institucion WHERE id_cliente = ? AND id_institucion = ?";
        try (PreparedStatement check = con.prepareStatement(sql)) {
            check.setInt(1, ci.getIdCliente());
            check.setInt(2, ci.getIdInstitucion());
            ResultSet rs = check.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) return false;
        }

        sql = "INSERT INTO cliente_institucion (id_cliente, id_institucion, fecha_asociacion) VALUES (?, ?, ?)";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, ci.getIdCliente());
            pst.setInt(2, ci.getIdInstitucion());
            pst.setDate(3, ci.getFechaAsociacion());
            return pst.executeUpdate() > 0;
        }
    }

    //  Obtener instituciones asociadas (por nombre)
    public List<String> obtenerInstitucionesAsociadas(int idCliente) {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT i.nombre FROM institucion i " +
                "JOIN cliente_institucion ci ON i.id_institucion = ci.id_institucion " +
                "WHERE ci.id_cliente = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, idCliente);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) lista.add(rs.getString("nombre"));
        } catch (SQLException e) {
            System.out.println("Error al obtener instituciones asociadas: " + e.getMessage());
        }
        return lista;
    }

    // Obtener instituciones no asociadas (por nombre)
    public List<String> obtenerInstitucionesNoAsociadas(int idCliente) {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT nombre FROM institucion WHERE id_institucion NOT IN " +
                "(SELECT id_institucion FROM cliente_institucion WHERE id_cliente = ?)";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, idCliente);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) lista.add(rs.getString("nombre"));
        } catch (SQLException e) {
            System.out.println("Error al obtener instituciones no asociadas: " + e.getMessage());
        }
        return lista;
    }

    // Obtener nombre del cliente por DUI
    public String obtenerNombrePorDui(String dui) {
        String sql = "SELECT nombre FROM cliente WHERE dui = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, dui);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) return rs.getString("nombre");
        } catch (SQLException e) {
            System.out.println("Error al obtener nombre del cliente: " + e.getMessage());
        }
        return "";
    }

    //  Obtener ID del cliente por DUI
    public int obtenerIdClientePorDui(String dui) {
        String sql = "SELECT id_cliente FROM cliente WHERE dui = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, dui);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) return rs.getInt("id_cliente");
        } catch (SQLException e) {
            System.out.println("Error al obtener ID del cliente: " + e.getMessage());
        }
        return -1;
    }
}
