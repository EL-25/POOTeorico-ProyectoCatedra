package com.udb.consorcio.dao;

import com.udb.consorcio.beans.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {
    public boolean insertarCliente(Cliente cliente) {
        try (Connection conn = Conexion.getConnection()) {
            if (conn != null && !existeCliente(conn, cliente.getDui())) {
                String sql = "INSERT INTO cliente (dui, nombre, fecha_nacimiento, genero, departamento, municipio, complemento, id_institucion) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, cliente.getDui());
                    stmt.setString(2, cliente.getNombre());
                    stmt.setDate(3, java.sql.Date.valueOf(cliente.getFechaNacimiento()));
                    stmt.setString(4, cliente.getGenero());
                    stmt.setString(5, cliente.getDepartamento());
                    stmt.setString(6, cliente.getMunicipio());
                    stmt.setString(7, cliente.getComplemento());
                    stmt.setInt(8, cliente.getIdInstitucion());

                    return stmt.executeUpdate() > 0;
                }
            } else {
                System.out.println("Cliente ya registrado con DUI: " + cliente.getDui());
            }
        } catch (SQLException e) {
            System.out.println("Error al registrar cliente: " + e.getMessage());
        }
        return false;
    }

    private boolean existeCliente(Connection conn, String dui) {
        String sql = "SELECT dui FROM cliente WHERE dui = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dui);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // Si hay resultado, ya existe
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar existencia de cliente: " + e.getMessage());
        }
        return false;
    }
}