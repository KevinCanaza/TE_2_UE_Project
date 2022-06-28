
package com.emergentes.modelo;

import java.util.Date;


public class PPFF {
    private String cod_ppff;
    private int ci;
    private String nombre;
    private String apellidos;
    private Date fecha_nacimiento;
    private String direccion;
    private String tipo_pariente;
    private int telefono;

    public PPFF() {
    }

    public String getCod_ppff() {
        return cod_ppff;
    }

    public void setCod_ppff(String cod_ppff) {
        this.cod_ppff = cod_ppff;
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

    public String getTipo_pariente() {
        return tipo_pariente;
    }

    public void setTipo_pariente(String tipo_pariente) {
        this.tipo_pariente = tipo_pariente;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "PPFF{" + "cod_ppff=" + cod_ppff + ", ci=" + ci + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fecha_nacimiento=" + fecha_nacimiento + ", direccion=" + direccion + ", tipo_pariente=" + tipo_pariente + ", telefono=" + telefono + '}';
    }
    
    
    
}
