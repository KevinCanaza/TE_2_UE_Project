package com.emergentes.modelo;

public class Materia {
    private String cod_mat;
    private String descripcion;
    private String sigla;

    public Materia() {
    }

    public String getCod_mat() {
        return cod_mat;
    }

    public void setCod_mat(String cod_mat) {
        this.cod_mat = cod_mat;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public String toString() {
        return "Materia{" + "cod_mat=" + cod_mat + ", descripcion=" + descripcion + ", sigla=" + sigla + '}';
    }
}
