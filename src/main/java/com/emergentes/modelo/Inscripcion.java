
package com.emergentes.modelo;

import java.util.Date;


public class Inscripcion {
    
    private String cod_inscripcion;
    private String rude1;
    private String cod_grado1;
    private String cod_turno;
    private Date fecha ;
    private String tipo_inscripcion;
    private String estudiante;
    private String  grado;
    private String turno;

    public Inscripcion() {
    }

    public String getCod_inscripcion() {
        return cod_inscripcion;
    }

    public void setCod_inscripcion(String cod_inscripcion) {
        this.cod_inscripcion = cod_inscripcion;
    }

    public String getRude1() {
        return rude1;
    }

    public void setRude1(String rude1) {
        this.rude1 = rude1;
    }

    public String getCod_grado1() {
        return cod_grado1;
    }

    public void setCod_grado1(String cod_grado1) {
        this.cod_grado1 = cod_grado1;
    }

    public String getCod_turno() {
        return cod_turno;
    }

    public void setCod_turno(String cod_turno) {
        this.cod_turno = cod_turno;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo_inscripcion() {
        return tipo_inscripcion;
    }

    public void setTipo_inscripcion(String tipo_inscripcion) {
        this.tipo_inscripcion = tipo_inscripcion;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "cod_inscripcion=" + cod_inscripcion + ", rude1=" + rude1 + ", cod_grado1=" + cod_grado1 + ", cod_turno=" + cod_turno + ", fecha=" + fecha + ", tipo_inscripcion=" + tipo_inscripcion + ", estudiante=" + estudiante + ", grado=" + grado + ", turno=" + turno + '}';
    }

   
    
    
}
