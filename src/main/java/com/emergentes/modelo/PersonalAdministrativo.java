package com.emergentes.modelo;

import java.sql.Date;

public class PersonalAdministrativo {
    private String cod_admi;
    private String nombre;
    private String apellidos;
    private String ci;
    private Date fecha_nac;
    private String direccion;
    private String telefono;
    private String cargo;

    public PersonalAdministrativo() {
    }

    public String getCod_admi() {
        return cod_admi;
    }

    public void setCod_admi(String cod_admi) {
        this.cod_admi = cod_admi;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "PersonalAdministrativo{" + "cod_admi=" + cod_admi + ", nombre=" + nombre + ", apellidos=" + apellidos + ", ci=" + ci + ", fecha_nac=" + fecha_nac + ", direccion=" + direccion + ", telefono=" + telefono + ", cargo=" + cargo + '}';
    }

    
}
