
package com.emergentes.modelo;


public class Turno {
    private String cod_turno;
    private String turno;
    private String inicio;
    private String fin;

    public Turno() {
    }

    public String getCod_turno() {
        return cod_turno;
    }

    public void setCod_turno(String cod_turno) {
        this.cod_turno = cod_turno;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    @Override
    public String toString() {
        return "Turno{" + "cod_turno=" + cod_turno + ", turno=" + turno + ", inicio=" + inicio + ", fin=" + fin + '}';
    }
    
    
    
}
