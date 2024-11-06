package com.hgallgo.prueba.model;

import java.time.LocalDate;

public class Persona {
    private Integer id;
    private String nombre;
    private String apellido;
    private String numeroDocumento;
    private String direccion;
    private LocalDate fechaIngreso;
    private TipoDocumento tipoDocumento;
    private Ciudad ciudad;

    public Persona() {
    }

    public Persona(String nombre, String appelido, String numeroDocumento,
                   String direccion, LocalDate fechaIngreso, TipoDocumento tipoDocumento, Ciudad ciudad) {
        this.nombre = nombre;
        this.apellido = appelido;
        this.numeroDocumento = numeroDocumento;
        this.direccion = direccion;
        this.fechaIngreso = fechaIngreso;
        this.tipoDocumento = tipoDocumento;
        this.ciudad = ciudad;
    }

    public Persona(Integer id, String nombre, String appelido,
                   String numeroDocumento, String direccion, LocalDate fechaIngreso, TipoDocumento tipoDocumento, Ciudad ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = appelido;
        this.numeroDocumento = numeroDocumento;
        this.direccion = direccion;
        this.fechaIngreso = fechaIngreso;
        this.tipoDocumento = tipoDocumento;
        this.ciudad = ciudad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
}
