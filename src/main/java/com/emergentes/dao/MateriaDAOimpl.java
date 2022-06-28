package com.emergentes.dao;

import com.emergentes.modelo.Materia;
import com.emergentes.utiles.ConexionDataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MateriaDAOimpl extends ConexionDataBase implements MateriaDAO {

    @Override
    public void insert(Materia materia) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO materias (cod_mat,descripcion,sigla) VALUES (?,?,?)");
            ps.setString(1, materia.getCod_mat());
            ps.setString(2, materia.getDescripcion());
            ps.setString(3, materia.getSigla());
           
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error1: "+e);
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Materia materia) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE materias SET descripcion=?,sigla=? WHERE cod_mat=?");
            
            ps.setString(1, materia.getDescripcion());
            ps.setString(2, materia.getSigla());
            ps.setString(3, materia.getCod_mat());
            
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error2: "+e);
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(String cod_mat) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM materias WHERE cod_mat=?");
            ps.setString(1, cod_mat);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error3: "+e);
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Materia> getAll() throws Exception {
        List<Materia> lista = null;
        try {
            this.conectar();
            String sql="SELECT * FROM materias";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Materia>();
            while (rs.next()) {
                Materia mat = new Materia();
                mat.setCod_mat(rs.getString("cod_mat"));
                mat.setDescripcion(rs.getString("descripcion"));
                mat.setSigla(rs.getString("sigla"));
                
                lista.add(mat);
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
    public Materia getById(String cod_mat) throws Exception {
        Materia mat = new Materia();
        try {
            this.conectar();
            String sql = "select * from materias where cod_mat=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, cod_mat);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mat.setCod_mat(rs.getString("cod_mat"));
                mat.setDescripcion(rs.getString("descripcion"));
                mat.setSigla(rs.getString("sigla"));
            }
        } catch (SQLException e) {
            System.out.println("error5: "+e);
        } finally {
            this.desconectar();
        }
        return mat;
    }

    @Override
    public List<Materia> buscar(String texto) throws Exception {
        List<Materia> lista = new ArrayList<>();
        String sql = "select * from materias where cod_mat like '%"+texto+"%' or descripcion like '%"+texto+"%' or sigla like '%"+texto+"%' ";
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                Materia mat = new Materia();
                mat.setCod_mat(rs.getString("cod_mat"));
                mat.setDescripcion(rs.getString("descripcion"));
                mat.setSigla(rs.getString("sigla"));
                lista.add(mat);
            }
        }catch(Exception e){
        }
        return lista;
    }  
}
