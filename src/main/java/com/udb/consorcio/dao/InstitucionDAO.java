package com.udb.consorcio.dao;

import com.udb.consorcio.beans.Institucion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InstitucionDAO {

    public boolean insertarInstitucion(Institucion institucion) {
        String sql = "INSERT INTO institucion (nombre, tipo, fecha_fundacion, id_consorcio) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, institucion.getNombre());
            stmt.setString(2, institucion.getTipo());
            stmt.setDate(3, java.sql.Date.valueOf(institucion.getFechaFundacion()));
            stmt.setInt(4, Integer.parseInt(institucion.getIdConcorcio()));

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al registrar institución: " + e.getMessage());
            return false;
        }
    }
}

