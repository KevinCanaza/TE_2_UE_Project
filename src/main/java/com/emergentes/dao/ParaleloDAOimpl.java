package com.emergentes.dao;

import com.emergentes.modelo.Paralelo;
import com.emergentes.utiles.ConexionDataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParaleloDAOimpl extends ConexionDataBase implements ParaleloDAO {

    @Override
    public void insert(Paralelo paralelo) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO paralelo (cod_paralelo,descripcion) values (?,?)");
            ps.setString(1, paralelo.getCod_paralelo());
            ps.setString(2, paralelo.getDescripcion());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar " + e.getMessage());
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Paralelo paralelo) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE paralelo SET descripcion = ? WHERE cod_paralelo = ?");

            ps.setString(1, paralelo.getDescripcion());
            ps.setString(2, paralelo.getCod_paralelo());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error" + e);
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(String cod_paralelo) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM paralelo WHERE cod_paralelo=?");
            ps.setString(1, cod_paralelo);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Paralelo> getAll() throws Exception {
        List<Paralelo> lista = null;
        try {
            this.conectar();
            String sql = "SELECT * FROM paralelo ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Paralelo>();
            while (rs.next()) {
                Paralelo pr = new Paralelo();

                pr.setCod_paralelo(rs.getString("cod_paralelo"));
                pr.setDescripcion(rs.getString("descripcion"));
                lista.add(pr);
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
    public Paralelo getById(String cod_paralelo) throws Exception {
        Paralelo pr = new Paralelo();
        try {
            this.conectar();
            String sql = "select * from paralelo where cod_paralelo=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, cod_paralelo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pr.setCod_paralelo(rs.getString("cod_paralelo"));
                pr.setDescripcion(rs.getString("descripcion"));
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            this.desconectar();
        }
        return pr;
    }

    @Override
    public List<Paralelo> buscar(String texto) throws Exception {
        List<Paralelo> lista = new ArrayList<>();
        String sql = "select * from paralelo where cod_paralelo like '%" + texto + "%' or descripcion like '%" + texto + "%' ";
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                Paralelo pr = new Paralelo();

                pr.setCod_paralelo(rs.getString("cod_paralelo"));
                pr.setDescripcion(rs.getString("descripcion"));
                lista.add(pr);

            }
        } catch (Exception e) {
        }
        return lista;

    }
}
