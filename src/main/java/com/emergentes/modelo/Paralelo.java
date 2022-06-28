
package com.emergentes.modelo;


public class Paralelo {
    private String cod_paralelo;
    private String descripcion;

    public Paralelo() {
    }

    public String getCod_paralelo() {
        return cod_paralelo;
    }

    public void setCod_paralelo(String cod_paralelo) {
        this.cod_paralelo = cod_paralelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Paralelo{" + "cod_paralelo=" + cod_paralelo + ", descripcion=" + descripcion + '}';
    }
    
    
    
}
