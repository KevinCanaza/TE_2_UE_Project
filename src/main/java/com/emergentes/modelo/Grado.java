
package com.emergentes.modelo;


public class Grado {
    
    private String cod_grado;
    private String descripcion;
    private String cod_paralelo;
    private String paralelo_desc;

    public Grado() {
    }

    public String getCod_grado() {
        return cod_grado;
    }

    public void setCod_grado(String cod_grado) {
        this.cod_grado = cod_grado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCod_paralelo() {
        return cod_paralelo;
    }

    public void setCod_paralelo(String cod_paralelo) {
        this.cod_paralelo = cod_paralelo;
    }

    public String getParalelo_desc() {
        return paralelo_desc;
    }

    public void setParalelo_desc(String paralelo_desc) {
        this.paralelo_desc = paralelo_desc;
    }

    @Override
    public String toString() {
        return "Grado{" + "cod_grado=" + cod_grado + ", descripcion=" + descripcion + ", cod_paralelo=" + cod_paralelo + ", paralelo_desc=" + paralelo_desc + '}';
    }
    
    
    
}
