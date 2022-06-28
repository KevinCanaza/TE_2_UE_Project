
package com.emergentes.modelo;


public class Nota {
    private String cod_nota;
    private String rude ;
    private int primer_trimestre;
    private int segundo_trimestre;
    private int tercer_trimestre;
    private int promedio;
    private String estudiante;

    public Nota() {
    }

    public String getCod_nota() {
        return cod_nota;
    }

    public void setCod_nota(String cod_nota) {
        this.cod_nota = cod_nota;
    }

    public String getRude() {
        return rude;
    }

    public void setRude(String rude) {
        this.rude = rude;
    }

    public int getPrimer_trimestre() {
        return primer_trimestre;
    }

    public void setPrimer_trimestre(int primer_trimestre) {
        this.primer_trimestre = primer_trimestre;
    }

    public int getSegundo_trimestre() {
        return segundo_trimestre;
    }

    public void setSegundo_trimestre(int segundo_trimestre) {
        this.segundo_trimestre = segundo_trimestre;
    }

    public int getTercer_trimestre() {
        return tercer_trimestre;
    }

    public void setTercer_trimestre(int tercer_trimestre) {
        this.tercer_trimestre = tercer_trimestre;
    }

    public int getPromedio() {
        return promedio;
    }

    public void setPromedio(int promedio) {
        this.promedio = promedio;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public String toString() {
        return "Nota{" + "cod_nota=" + cod_nota + ", rude=" + rude + ", primer_trimestre=" + primer_trimestre + ", segundo_trimestre=" + segundo_trimestre + ", tercer_trimestre=" + tercer_trimestre + ", promedio=" + promedio + ", estudiante=" + estudiante + '}';
    }

    

}
