package com.udb.consorcio.dao;

import com.udb.consorcio.beans.Institucion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InstitucionDAO {

    public boolean insertarInstitucion(Institucion institucion) {
        try (Connection conn = Conexion.getConnection()) {
            if (conn != null && !existeInstitucion(conn, institucion.getNombre())) {
                String sql = "INSERT INTO institucion (nombre, tipo, fecha_fundacion, id_consorcio) VALUES (?, ?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, institucion.getNombre());
                    stmt.setString(2, institucion.getTipo());
                    stmt.setDate(3, java.sql.Date.valueOf(institucion.getFechaFundacion()));
                    stmt.setInt(4, Integer.parseInt(institucion.getIdConcorcio()));
                    return stmt.executeUpdate() > 0;
                }
            } else {
                System.out.println("Institución ya existe.");
            }
        } catch (SQLException e) {
            System.out.println("Error al registrar institución: " + e.getMessage());
        }
        return false;
    }

    private boolean existeInstitucion(Connection conn, String nombre) {
        String sql = "SELECT nombre FROM institucion WHERE nombre = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Si hay resultado, ya existe
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar existencia: " + e.getMessage());
        }
        return false;
    }
}
