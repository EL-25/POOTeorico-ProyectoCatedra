package com.udb.consorcio.beans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Institucion {
    private String idInstitucion; // opcional, generado por la BD
    private String nombre;
    private String tipo;
    private LocalDate fechaFundacion;
    private String idConcorcio;

    public Institucion() {}

    // Constructor sin idInstitucion, usado en el registro
    public Institucion(String nombre, String tipo, String fechaFundacion, String idConcorcio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.fechaFundacion = LocalDate.parse(fechaFundacion, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.idConcorcio = idConcorcio;
    }

    public String getIdInstitucion() { return idInstitucion; }
    public void setIdInstitucion(String idInstitucion) { this.idInstitucion = idInstitucion; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public LocalDate getFechaFundacion() { return fechaFundacion; }
    public void setFechaFundacion(LocalDate fechaFundacion) { this.fechaFundacion = fechaFundacion; }

    public String getIdConcorcio() { return idConcorcio; }
    public void setIdConcorcio(String idConcorcio) { this.idConcorcio = idConcorcio; }
}
