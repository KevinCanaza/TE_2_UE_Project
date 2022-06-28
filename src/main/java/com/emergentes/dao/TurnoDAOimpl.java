package com.emergentes.dao;

import com.emergentes.modelo.Turno;
import com.emergentes.utiles.ConexionDataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TurnoDAOimpl extends ConexionDataBase implements TurnoDAO {

    @Override
    public void insert(Turno turno) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO turno (cod_turno,turno,inicio,fin) values (?,?,?,?)");
            ps.setString(1, turno.getCod_turno());
            ps.setString(2, turno.getTurno());
            ps.setString(3, turno.getInicio());
            ps.setString(4, turno.getFin());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Turno turno) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE turno SET turno=?,inicio=?,fin=? WHERE cod_turno=?");

            ps.setString(1, turno.getTurno());
            ps.setString(2, turno.getInicio());
            ps.setString(3, turno.getFin());
            ps.setString(4, turno.getCod_turno());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(String cod_turno) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM turno WHERE cod_turno=?");
            ps.setString(1, cod_turno);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Turno> getAll() throws Exception {
        List<Turno> lista = null;
        try {
            this.conectar();
            String sql = "SELECT * FROM turno ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Turno>();
            while (rs.next()) {
                Turno t = new Turno();

                t.setCod_turno(rs.getString("cod_turno"));
                t.setTurno(rs.getString("turno"));
                t.setInicio(rs.getString("inicio"));
                t.setFin(rs.getString("fin"));
                lista.add(t);
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
    public Turno getById(String cod_turno) throws Exception {
        Turno t = new Turno();
        try {
            this.conectar();
            String sql = "select * from turno where cod_turno=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, cod_turno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                t.setCod_turno(rs.getString("cod_turno"));
                t.setTurno(rs.getString("turno"));
                t.setInicio(rs.getString("inicio"));
                t.setFin(rs.getString("fin"));

            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            this.desconectar();
        }
        return t;
    }

    @Override
    public List<Turno> buscar(String texto) throws Exception {
        List<Turno> lista = new ArrayList<>();
        String sql = "select * from turno where cod_turno like '%" + texto + "%' or turno like '%" + texto + "%' or inicio like '%" + texto + "%' or fin like '%" + texto + "%' ";
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                Turno t = new Turno();

                t.setCod_turno(rs.getString("cod_turno"));
                t.setTurno(rs.getString("turno"));
                t.setInicio(rs.getString("inicio"));
                t.setFin(rs.getString("fin"));
                lista.add(t);
            }
        } catch (Exception e) {
        }
        return lista;

    }

}
