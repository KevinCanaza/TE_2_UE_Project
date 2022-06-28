package com.emergentes.dao;

import com.emergentes.modelo.Usuario;
import com.emergentes.utiles.ConexionDataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOimpl extends ConexionDataBase implements UsuarioDAO {

    @Override
    public void insert(Usuario usuario) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO usuarios (nombre,apellidos,usuario,contraseña,tipo_usuario) VALUES (?,?,?,?,?)");
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellidos());
            ps.setString(3, usuario.getUsuario());
            ps.setString(4, usuario.getContraseña());
            ps.setString(5, usuario.getTipo_usuario());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error1: "+e);
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Usuario usuario) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE usuarios SET nombre=?, apellidos=?, usuario=?, contraseña=?, tipo_usuario=? WHERE cod_usr=?");
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellidos());
            ps.setString(3, usuario.getUsuario());
            ps.setString(4, usuario.getContraseña());
            ps.setString(5, usuario.getTipo_usuario());
            ps.setInt(6, usuario.getCod_usr());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error2: "+e);
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int cod_usr) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM usuarios WHERE cod_usr=?");
            ps.setInt(1, cod_usr);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error3: "+e);
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Usuario> getAll() throws Exception {
        List<Usuario> lista = null;
        try {
            this.conectar();
            String sql="SELECT * FROM usuarios";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Usuario>();
            while (rs.next()) {
                Usuario u = new Usuario();

                u.setCod_usr(rs.getInt("cod_usr"));
                u.setNombre(rs.getString("nombre"));
                u.setApellidos(rs.getString("apellidos"));
                u.setUsuario(rs.getString("usuario"));
                u.setContraseña(rs.getString("contraseña"));
                u.setTipo_usuario(rs.getString("tipo_usuario"));
                
                lista.add(u);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("error4: "+e); 
        } finally {
            this.desconectar();
        }
        return lista;
    }

    @Override
    public Usuario getById(int cod_usr) throws Exception {
        Usuario u = new Usuario();
        try {
            this.conectar();
            String sql = "select * from usuarios where cod_usr=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, cod_usr);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u.setCod_usr(rs.getInt("cod_usr"));
                u.setNombre(rs.getString("nombre"));
                u.setApellidos(rs.getString("apellidos"));
                u.setUsuario(rs.getString("usuario"));
                u.setContraseña(rs.getString("contraseña"));
                u.setTipo_usuario(rs.getString("tipo_usuario"));
            }
        } catch (SQLException e) {
            System.out.println("error5: "+e);
        } finally {
            this.desconectar();
        }
        return u;
    }

    @Override
    public List<Usuario> buscar(String texto) throws Exception {
        List<Usuario> lista = new ArrayList<>();
        String sql = "select * from usuarios where cod_usr like '%"+texto+"%' or nombre like '%"+texto+"%' or apellidos like '%"+texto+"%' or usuario like '%"+texto+"%' or tipo_usuario like '%"+texto+"%' ";
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario();
                u.setCod_usr(rs.getInt("cod_usr"));
                u.setNombre(rs.getString("nombre"));
                u.setApellidos(rs.getString("apellidos"));
                u.setUsuario(rs.getString("usuario"));
                u.setContraseña(rs.getString("contraseña"));
                u.setTipo_usuario(rs.getString("tipo_usuario"));
                lista.add(u);
            }
        }catch(Exception e){
        }
        return lista;
    }
}
