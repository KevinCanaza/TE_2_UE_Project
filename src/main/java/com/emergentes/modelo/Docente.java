package com.emergentes.modelo;

import java.sql.Date;

public class Docente {
    private String cod_doc;
    private String nombre;
    private String apellidos;
    private String ci;
    private String direccion;
    private Date fecha_nac;
    private String telefono;
    
    private String cod_mat;
    private String cod_grado;
    
    private String materia ;
    private String grado ;

    public Docente() {
    }

    public String getCod_doc() {
        return cod_doc;
    }

    public void setCod_doc(String cod_doc) {
        this.cod_doc = cod_doc;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCod_mat() {
        return cod_mat;
    }

    public void setCod_mat(String cod_mat) {
        this.cod_mat = cod_mat;
    }

    public String getCod_grado() {
        return cod_grado;
    }

    public void setCod_grado(String cod_grado) {
        this.cod_grado = cod_grado;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    @Override
    public String toString() {
        return "Docente{" + "cod_doc=" + cod_doc + ", nombre=" + nombre + ", apellidos=" + apellidos + ", ci=" + ci + ", direccion=" + direccion + ", fecha_nac=" + fecha_nac + ", telefono=" + telefono + ", cod_mat=" + cod_mat + ", cod_grado=" + cod_grado + ", materia=" + materia + ", grado=" + grado + '}';
    }

}
