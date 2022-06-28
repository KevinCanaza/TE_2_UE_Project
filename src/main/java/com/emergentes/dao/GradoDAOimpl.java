package com.emergentes.dao;

import com.emergentes.modelo.Grado;
import com.emergentes.utiles.ConexionDataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GradoDAOimpl extends ConexionDataBase implements GradoDAO {

    @Override
    public void insert(Grado grado) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO grado (cod_grado,descripcion,cod_paralelo) values (?,?,?)");
            ps.setString(1, grado.getCod_grado());
            ps.setString(2, grado.getDescripcion());
            ps.setString(3, grado.getCod_paralelo());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Grado grado) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE grado SET descripcion=?,cod_paralelo=? WHERE cod_grado=?");
            
            ps.setString(1, grado.getDescripcion());
            ps.setString(2, grado.getCod_paralelo());
            ps.setString(3, grado.getCod_grado());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(String cod_grado) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM grado WHERE cod_grado=?");
            ps.setString(1, cod_grado);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Grado> getAll() throws Exception {
        List<Grado> lista = null;
        try {
            this.conectar();
            String sql = "SELECT g.* , p.descripcion as paralelo_desc FROM grado g LEFT JOIN paralelo p ON g.cod_paralelo=p.cod_paralelo ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Grado>();
            while (rs.next()) {
                Grado g = new Grado();

                g.setCod_grado(rs.getString("cod_grado"));
                g.setDescripcion(rs.getString("descripcion"));
                g.setCod_paralelo(rs.getString("cod_paralelo"));
                g.setParalelo_desc(rs.getString("paralelo_desc"));
                lista.add(g);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;

    }

    @Override
    public Grado getById(String cod_grado) throws Exception {
        Grado g = new Grado();
        try {
            this.conectar();
            String sql = "select * from grado where cod_grado=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, cod_grado);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                g.setCod_grado(rs.getString("cod_grado"));
                g.setDescripcion(rs.getString("descripcion"));
                g.setCod_paralelo(rs.getString("cod_paralelo"));
                
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            this.desconectar();
        }
        return g;
    }

    @Override
    public List<Grado> buscar(String texto) throws Exception {
        List<Grado> lista = new ArrayList<>();
        String sql = "select g.* , p.descripcion as paralelo_desc from grado g , paralelo p where (g.cod_grado like '%"+texto+"%' or g.descripcion like '%"+texto+"%') and g.cod_paralelo =p .cod_paralelo";
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                Grado g = new Grado();
                g.setCod_grado(rs.getString("cod_grado"));
                g.setDescripcion(rs.getString("descripcion"));
                g.setCod_paralelo(rs.getString("cod_paralelo"));
                g.setParalelo_desc(rs.getString("paralelo_desc"));
                lista.add(g);
               
            }
        }catch(Exception e){
        }
        return lista;

    }
}
