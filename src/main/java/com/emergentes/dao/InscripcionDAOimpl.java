package com.emergentes.dao;

import com.emergentes.modelo.Inscripcion;
import com.emergentes.utiles.ConexionDataBase;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InscripcionDAOimpl extends ConexionDataBase implements InscripcionDAO {

    @Override
    public void insert(Inscripcion inscripcion) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO inscripcion (cod_inscripcion,rude1,cod_grado1,cod_turno,fecha,tipo_inscripcion) values (?,?,?,?,?,?)");
            ps.setString(1, inscripcion.getCod_inscripcion());
            ps.setString(2, inscripcion.getRude1());
            ps.setString(3, inscripcion.getCod_grado1());
            ps.setString(4, inscripcion.getCod_turno());
            ps.setDate(5, (Date) inscripcion.getFecha());
            ps.setString(6, inscripcion.getTipo_inscripcion());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Inscripcion inscripcion) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE inscripcion SET rude1=?,cod_grado1=?,cod_turno=?,fecha=?,tipo_inscripcion=? WHERE cod_inscripcion=?");

            ps.setString(1, inscripcion.getRude1());
            ps.setString(2, inscripcion.getCod_grado1());
            ps.setString(3, inscripcion.getCod_turno());
            ps.setDate(4, (Date) inscripcion.getFecha());
            ps.setString(5, inscripcion.getTipo_inscripcion());
            ps.setString(6, inscripcion.getCod_inscripcion());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(String cod_inscripcion) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM inscripcion WHERE cod_inscripcion=?");
            ps.setString(1, cod_inscripcion);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Inscripcion> getAll() throws Exception {
        List<Inscripcion> lista = null;
        try {
            this.conectar();
            String sql = "SELECT i.*,CONCAT(e.nombre,' ',e.apellidos) as estudiante,g.descripcion as grado,t.turno FROM inscripcion i ,estudiantes e, turno t , grado g WHERE i.cod_grado1 = g.cod_grado  AND i.cod_turno = t.cod_turno AND i.rude1 = e.rude";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Inscripcion>();
            while (rs.next()) {
                Inscripcion in = new Inscripcion();
                in.setCod_inscripcion(rs.getString("cod_inscripcion"));
                in.setRude1(rs.getString("rude1"));
                in.setCod_grado1(rs.getString("cod_grado1"));
                in.setCod_turno(rs.getString("cod_turno"));
                in.setFecha(rs.getDate("fecha"));
                in.setTipo_inscripcion(rs.getString("tipo_inscripcion"));
                in.setEstudiante(rs.getString("estudiante"));
                in.setGrado(rs.getString("grado"));
                in.setTurno(rs.getString("turno"));

                lista.add(in);
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
    public Inscripcion getById(String cod_inscripcion) throws Exception {
        Inscripcion in = new Inscripcion();
        try {
            this.conectar();
            String sql = "select * from inscripcion where cod_inscripcion=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, cod_inscripcion);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                in.setCod_inscripcion(rs.getString("cod_inscripcion"));
                in.setRude1(rs.getString("rude1"));
                in.setCod_grado1(rs.getString("cod_grado1"));
                in.setCod_turno(rs.getString("cod_turno"));
                in.setFecha(rs.getDate("fecha"));
                in.setTipo_inscripcion(rs.getString("tipo_inscripcion"));

            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            this.desconectar();
        }
        return in;

    }

    @Override
    public List<Inscripcion> buscar(String texto) throws Exception {
        List<Inscripcion> lista = new ArrayList<>();
        String sql = "SELECT i.*,CONCAT(e.nombre,' ',e.apellidos) as estudiante,g.descripcion as grado,t.turno FROM inscripcion i ,estudiantes e, turno t , grado g WHERE (i.cod_inscripcion like '%"+texto+"%' OR e.nombre like '%"+texto+"%' OR e.apellidos like '%"+texto+"%' OR t.turno like '%"+texto+"%' OR g.descripcion like '%"+texto+"%' OR i.fecha like '%"+texto+"%' OR i.tipo_inscripcion like '%"+texto+"%') AND i.cod_grado1 = g.cod_grado  AND i.cod_turno = t.cod_turno and i.rude1 = e.rude ";
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion in = new Inscripcion();
                in.setCod_inscripcion(rs.getString("cod_inscripcion"));
                in.setRude1(rs.getString("rude1"));
                in.setCod_grado1(rs.getString("cod_grado1"));
                in.setCod_turno(rs.getString("cod_turno"));
                in.setFecha(rs.getDate("fecha"));
                in.setTipo_inscripcion(rs.getString("tipo_inscripcion"));
                in.setEstudiante(rs.getString("estudiante"));
                in.setGrado(rs.getString("grado"));
                in.setTurno(rs.getString("turno"));

                lista.add(in);
            }
        } catch (Exception e) {
        }
        return lista;

    }

}
