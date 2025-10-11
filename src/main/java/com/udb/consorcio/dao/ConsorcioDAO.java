package com.udb.consorcio.dao;

import com.udb.consorcio.beans.Consorcio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsorcioDAO {

    public boolean insertarConsorcio(Consorcio consorcio) {
        boolean exito = false;
        try (Connection conn = Conexion.getConnection()) {
            if (conn != null && !existeConsorcio(conn, consorcio.getIdConsorcio())) {
                String sql = "INSERT INTO consorcio (id_consorcio, nombre, fecha_registro) VALUES (?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, consorcio.getIdConsorcio());
                    stmt.setString(2, consorcio.getNombreConsorcio());
                    stmt.setDate(3, java.sql.Date.valueOf(consorcio.getFechaRegistro()));
                    int filas = stmt.executeUpdate();
                    exito = filas > 0;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar consorcio: " + e.getMessage());
            e.printStackTrace();
        }
        return exito;
    }

    private boolean existeConsorcio(Connection conn, String idConsorcio) {
        String sql = "SELECT id_consorcio FROM consorcio WHERE id_consorcio = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idConsorcio);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar existencia de consorcio: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
}