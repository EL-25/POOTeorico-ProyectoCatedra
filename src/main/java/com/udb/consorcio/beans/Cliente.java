package com.udb.consorcio.beans;

public class Cliente {
    private int idCliente;
    private String dui;
    private String nombre;
    private String fechaNacimiento;
    private String genero;
    private String departamento;
    private String municipio;
    private String complemento;
    private int idInstitucion;

    public Cliente() {}

    public Cliente(String dui, String nombre, String fechaNacimiento, String genero,
                   String departamento, String municipio, String complemento, int idInstitucion) {
        this.dui = dui;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.departamento = departamento;
        this.municipio = municipio;
        this.complemento = complemento;
        this.idInstitucion = idInstitucion;
    }

    // Getters y Setters
    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public String getDui() { return dui; }
    public void setDui(String dui) { this.dui = dui; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

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

    public int getIdInstitucion() { return idInstitucion; }
    public void setIdInstitucion(int idInstitucion) { this.idInstitucion = idInstitucion; }
}