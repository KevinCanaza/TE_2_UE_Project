package com.emergentes.dao;

import com.emergentes.modelo.Estudiantes;
import com.emergentes.utiles.ConexionDataBase;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public class EstudiantesDAOimpl extends ConexionDataBase implements EstudiantesDAO {

    @Override
    public void insert(Estudiantes estudiante) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO estudiantes (rude,ci,nombre,apellidos,fecha_nacimiento,direccion,estado,cod_ppff) values (?,?,?,?,?,?,?,?)");
            ps.setString(1, estudiante.getRude());
            ps.setInt(2, estudiante.getCi());
            ps.setString(3, estudiante.getNombre());
            ps.setString(4, estudiante.getApellidos());
            ps.setDate(5, (Date) estudiante.getFecha_nacimiento());
            ps.setString(6, estudiante.getDireccion());
            ps.setString(7, estudiante.getEstado());
            ps.setString(8, estudiante.getCod_ppff());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Estudiantes estudiante) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE estudiantes SET ci=?, nombre=? , apellidos=?,fecha_nacimiento=?,direccion=?,estado=?,cod_ppff=? WHERE rude=?");
            
            ps.setInt(1, estudiante.getCi());
            ps.setString(2, estudiante.getNombre());
            ps.setString(3, estudiante.getApellidos());
            ps.setDate(4, (Date) estudiante.getFecha_nacimiento());
            ps.setString(5, estudiante.getDireccion());
            ps.setString(6, estudiante.getEstado());
            ps.setString(7, estudiante.getCod_ppff());
            ps.setString(8, estudiante.getRude());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    public void delete(String rude) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM estudiantes WHERE rude=?");
            ps.setString(1, rude);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Estudiantes> getAll() throws Exception {
        List<Estudiantes> lista = null;
        try {
            this.conectar();
            String sql = "SELECT e.* , CONCAT(p.nombre,' ',p.apellidos) as nombre_ppff FROM estudiantes e LEFT JOIN ppff p ON e.cod_ppff = p.cod_ppff ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Estudiantes>();
            while (rs.next()) {
                Estudiantes e = new Estudiantes();

                e.setRude(rs.getString("rude"));
                e.setCi(rs.getInt("ci"));
                e.setNombre(rs.getString("nombre"));
                e.setApellidos(rs.getString("apellidos"));
                e.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                e.setDireccion(rs.getString("direccion"));
                e.setEstado(rs.getString("estado"));
                e.setCod_ppff(rs.getString("cod_ppff"));
                e.setNombre_ppff(rs.getString("nombre_ppff"));

                lista.add(e);
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

    public Estudiantes getById(String rude) throws Exception {
        Estudiantes e = new Estudiantes();
        try {
            this.conectar();
            String sql = "select * from estudiantes where rude=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, rude);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                e.setRude(rs.getString("rude"));
                e.setCi(rs.getInt("ci"));
                e.setNombre(rs.getString("nombre"));
                e.setApellidos(rs.getString("apellidos"));
                e.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                e.setDireccion(rs.getString("direccion"));
                e.setEstado(rs.getString("estado"));
                e.setCod_ppff(rs.getString("cod_ppff"));
                
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            this.desconectar();
        }
        return e;
    }

    @Override
    public List<Estudiantes> buscar(String texto) throws Exception {
        List<Estudiantes> lista = new ArrayList<>();
        String sql = "select e.* , CONCAT(p.nombre,' ',p.apellidos) as nombre_ppff from estudiantes e ,ppff p WHERE (e.rude like '%"+texto+"%' or e.ci like '%"+texto+"%' or e.nombre like '%"+texto+"%' or e.apellidos like '%"+texto+"%' or e.fecha_nacimiento like '%"+texto+"%' or e.direccion like '%"+texto+"%' or e.estado like '%"+texto+"%' or p.nombre like '%"+texto+"%' or p.apellidos like '%"+texto+"%') and e.cod_ppff = p.cod_ppff ";
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                Estudiantes e = new Estudiantes();
                e.setRude(rs.getString("rude"));
                e.setCi(rs.getInt("ci"));
                e.setNombre(rs.getString("nombre"));
                e.setApellidos(rs.getString("apellidos"));
                e.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                e.setDireccion(rs.getString("direccion"));
                e.setEstado(rs.getString("estado"));
                e.setCod_ppff(rs.getString("cod_ppff"));
                 e.setNombre_ppff(rs.getString("nombre_ppff"));
                lista.add(e);
            }
        }catch(Exception e){
        }
        return lista;
    }
}


