
package com.emergentes.modelo;

import java.util.Date;


public class Estudiantes {
    private String rude;
    private int ci;
    private String nombre;
    private String apellidos;
    private Date fecha_nacimiento;
    private String direccion;
    private String estado;
    private String cod_ppff;
    private String nombre_ppff;

    public Estudiantes() {
    }

    public String getRude() {
        return rude;
    }

    public void setRude(String rude) {
        this.rude = rude;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
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

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCod_ppff() {
        return cod_ppff;
    }

    public void setCod_ppff(String cod_ppff) {
        this.cod_ppff = cod_ppff;
    }

    public String getNombre_ppff() {
        return nombre_ppff;
    }

    public void setNombre_ppff(String nombre_ppff) {
        this.nombre_ppff = nombre_ppff;
    }

    @Override
    public String toString() {
        return "Estudiantes{" + "rude=" + rude + ", ci=" + ci + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fecha_nacimiento=" + fecha_nacimiento + ", direccion=" + direccion + ", estado=" + estado + ", cod_ppff=" + cod_ppff + ", nombre_ppff=" + nombre_ppff + '}';
    }
    
    
    
    
}
