package com.emergentes.modelo;

import java.sql.Date;

public class PermisoLaboral {
    private String cod_permiso;
    private String descripcion;
    private Date fecha;
    private Date fecha_inicio;
    private Date fecha_final;

    private String cod_doc;
    private String cod_admi;
    
    private String docente ;
    private String personal ;

    public PermisoLaboral() {
    }

    public String getCod_permiso() {
        return cod_permiso;
    }

    public void setCod_permiso(String cod_permiso) {
        this.cod_permiso = cod_permiso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(Date fecha_final) {
        this.fecha_final = fecha_final;
    }

    public String getCod_doc() {
        return cod_doc;
    }

    public void setCod_doc(String cod_doc) {
        this.cod_doc = cod_doc;
    }

    public String getCod_admi() {
        return cod_admi;
    }

    public void setCod_admi(String cod_admi) {
        this.cod_admi = cod_admi;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    @Override
    public String toString() {
        return "PermisoLaboral{" + "cod_permiso=" + cod_permiso + ", descripcion=" + descripcion + ", fecha=" + fecha + ", fecha_inicio=" + fecha_inicio + ", fecha_final=" + fecha_final + ", cod_doc=" + cod_doc + ", cod_admi=" + cod_admi + ", docente=" + docente + ", personal=" + personal + '}';
    }
}
