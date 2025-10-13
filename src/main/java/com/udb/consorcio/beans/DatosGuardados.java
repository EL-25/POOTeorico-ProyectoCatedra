package com.udb.consorcio.beans;

import java.time.LocalDate;

public class DatosGuardados {
    //  Consorcio
    private String idConsorcio;
    private String nombreConsorcio;
    private LocalDate fechaRegistro;

    //  Institución
    private String idInstitucion;
    private String nombreInstitucion;
    private String tipoInstitucion;
    private LocalDate fechaFundacion;
    private String perteneceConsorcio;

    //  Cliente
    private int idCliente;
    private String dui;
    private String nombreCliente;
    private String fechaNacimiento;
    private String genero;
    private String departamento;
    private String municipio;
    private String complemento;

    public DatosGuardados() {}

    //  Getters y Setters para Consorcio
    public String getIdConsorcio() { return idConsorcio; }
    public void setIdConsorcio(String idConsorcio) { this.idConsorcio = idConsorcio; }

    public String getNombreConsorcio() { return nombreConsorcio; }
    public void setNombreConsorcio(String nombreConsorcio) { this.nombreConsorcio = nombreConsorcio; }

    public LocalDate getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDate fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    //  Getters y Setters para Institución
    public String getIdInstitucion() { return idInstitucion; }
    public void setIdInstitucion(String idInstitucion) { this.idInstitucion = idInstitucion; }

    public String getNombreInstitucion() { return nombreInstitucion; }
    public void setNombreInstitucion(String nombreInstitucion) { this.nombreInstitucion = nombreInstitucion; }

    public String getTipoInstitucion() { return tipoInstitucion; }
    public void setTipoInstitucion(String tipoInstitucion) { this.tipoInstitucion = tipoInstitucion; }

    public LocalDate getFechaFundacion() { return fechaFundacion; }
    public void setFechaFundacion(LocalDate fechaFundacion) { this.fechaFundacion = fechaFundacion; }

    public String getPerteneceConsorcio() { return perteneceConsorcio; }
    public void setPerteneceConsorcio(String perteneceConsorcio) { this.perteneceConsorcio = perteneceConsorcio; }

    //  Getters y Setters para Cliente
    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public String getDui() { return dui; }
    public void setDui(String dui) { this.dui = dui; }

    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }

    public String getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    public String getMunicipio() { return municipio; }
    public void setMunicipio(String municipio) { this.municipio = municipio; }

    public String getComplemento() { return complemento; }
    public void setComplemento(String complemento) { this.complemento = complemento; }
}
