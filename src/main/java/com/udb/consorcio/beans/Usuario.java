package com.udb.consorcio.beans;

public class Usuario {
    private String idUsuario;
    private String contrasena;

    public Usuario() {
        // Constructor vacío requerido por algunos frameworks
    }

    public Usuario(String idUsuario, String contrasena) {
        this.idUsuario = idUsuario;
        this.contrasena = contrasena;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}