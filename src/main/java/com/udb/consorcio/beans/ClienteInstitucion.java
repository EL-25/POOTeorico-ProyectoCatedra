package com.udb.consorcio.beans;

import java.sql.Date;

public class ClienteInstitucion {
    private int idCliente;
    private int idInstitucion;
    private Date fechaAsociacion;

    public ClienteInstitucion() {}

    public ClienteInstitucion(int idCliente, int idInstitucion, Date fechaAsociacion) {
        this.idCliente = idCliente;
        this.idInstitucion = idInstitucion;
        this.fechaAsociacion = fechaAsociacion;
    }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public int getIdInstitucion() { return idInstitucion; }
    public void setIdInstitucion(int idInstitucion) { this.idInstitucion = idInstitucion; }

    public Date getFechaAsociacion() { return fechaAsociacion; }
    public void setFechaAsociacion(Date fechaAsociacion) { this.fechaAsociacion = fechaAsociacion; }
}
