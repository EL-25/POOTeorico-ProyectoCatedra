package com.udb.consorcio.beans;

import java.time.LocalDate;

public class Consorcio {
    private String idConsorcio;
    private String nombreConsorcio;
    private LocalDate fechaRegistro;

    public Consorcio() {
        // Constructor vacío requerido por JSP/Servlet
    }

    public Consorcio(String idConsorcio, String nombreConsorcio, LocalDate fechaRegistro) {
        this.idConsorcio = idConsorcio;
        this.nombreConsorcio = nombreConsorcio;
        this.fechaRegistro = fechaRegistro;
    }

    public String getIdConsorcio() {
        return idConsorcio;
    }

    public void setIdConsorcio(String idConsorcio) {
        this.idConsorcio = idConsorcio;
    }

    public String getNombreConsorcio() {
        return nombreConsorcio;
    }

    public void setNombreConsorcio(String nombreConsorcio) {
        this.nombreConsorcio = nombreConsorcio;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}