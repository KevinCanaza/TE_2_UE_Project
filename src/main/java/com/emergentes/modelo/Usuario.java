package com.emergentes.modelo;

public class Usuario {
    private int cod_usr;
    private String nombre;
    private String apellidos;
    private String usuario;
    private String contraseña;
    private String tipo_usuario;

    public Usuario() {
    }

    public int getCod_usr() {
        return cod_usr;
    }

    public void setCod_usr(int cod_usr) {
        this.cod_usr = cod_usr;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "cod_usr=" + cod_usr + ", nombre=" + nombre + ", apellidos=" + apellidos + ", usuario=" + usuario + ", contrase\u00f1a=" + contraseña + ", tipo_usuario=" + tipo_usuario + '}';
    }
    
    
}
