package com.emergentes.dao;

import com.emergentes.modelo.PPFF;
import com.emergentes.utiles.ConexionDataBase;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PPFFDAOimpl extends ConexionDataBase implements PPFFDAO {

    @Override
    public void insert(PPFF ppff) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO ppff (cod_ppff,ci,nombre,apellidos,fecha_nacimiento,direccion,tipo_pariente,telefono) values (?,?,?,?,?,?,?,?)");
            ps.setString(1, ppff.getCod_ppff());
            ps.setInt(2, ppff.getCi());
            ps.setString(3, ppff.getNombre());
            ps.setString(4, ppff.getApellidos());
            ps.setDate(5, (Date) ppff.getFecha_nacimiento());
            ps.setString(6, ppff.getDireccion());
            ps.setString(7, ppff.getTipo_pariente());
            ps.setInt(8, ppff.getTelefono());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(PPFF ppff) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE ppff SET ci=?,nombre=?,apellidos=?,fecha_nacimiento=?,direccion=?,tipo_pariente=?,telefono=? WHERE cod_ppff=?");
            ps.setInt(1, ppff.getCi());
            ps.setString(2, ppff.getNombre());
            ps.setString(3, ppff.getApellidos());
            ps.setDate(4, (Date) ppff.getFecha_nacimiento());
            ps.setString(5, ppff.getDireccion());
            ps.setString(6, ppff.getTipo_pariente());
            ps.setInt(7, ppff.getTelefono());
            ps.setString(8, ppff.getCod_ppff());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(String cod_ppff) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM ppff WHERE cod_ppff=?");
            ps.setString(1, cod_ppff);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<PPFF> getAll() throws Exception {
        List<PPFF> lista = null;
        try {
            this.conectar();
            String sql = "SELECT * FROM ppff ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<PPFF>();
            while (rs.next()) {
                PPFF p = new PPFF();

                p.setCod_ppff(rs.getString("cod_ppff"));
                p.setCi(rs.getInt("ci"));
                p.setNombre(rs.getString("nombre"));
                p.setApellidos(rs.getString("apellidos"));
                p.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                p.setDireccion(rs.getString("direccion"));
                p.setTipo_pariente(rs.getString("tipo_pariente"));
                p.setTelefono(rs.getInt("telefono"));

                lista.add(p);
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
    public PPFF getById(String cod_ppff) throws Exception {
        PPFF p = new PPFF();
        try {
            this.conectar();
            String sql = "select * from ppff where cod_ppff=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, cod_ppff);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p.setCod_ppff(rs.getString("cod_ppff"));
                p.setCi(rs.getInt("ci"));
                p.setNombre(rs.getString("nombre"));
                p.setApellidos(rs.getString("apellidos"));
                p.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                p.setDireccion(rs.getString("direccion"));
                p.setTipo_pariente(rs.getString("tipo_pariente"));
                p.setTelefono(rs.getInt("telefono"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return p;
    }

    @Override
    public List<PPFF> buscar(String texto) throws Exception {
               List<PPFF> lista = new ArrayList<>();
        String sql = "select * from ppff where cod_ppff like '%"+texto+"%' or ci like '%"+texto+"%' or nombre like '%"+texto+"%' or apellidos like '%"+texto+"%' or fecha_nacimiento like '%"+texto+"%' or direccion like '%"+texto+"%' or tipo_pariente like '%"+texto+"%' or telefono like '%"+texto+"%'";
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                PPFF p = new PPFF();

                p.setCod_ppff(rs.getString("cod_ppff"));
                p.setCi(rs.getInt("ci"));
                p.setNombre(rs.getString("nombre"));
                p.setApellidos(rs.getString("apellidos"));
                p.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                p.setDireccion(rs.getString("direccion"));
                p.setTipo_pariente(rs.getString("tipo_pariente"));
                p.setTelefono(rs.getInt("telefono"));

                lista.add(p);
            }
        }catch(Exception e){
        }
        return lista;

    }

}


