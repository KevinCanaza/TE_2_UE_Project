package com.emergentes.dao;

import com.emergentes.modelo.PermisoLaboral;
import com.emergentes.utiles.ConexionDataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PermisoLaboralDAOimpl extends ConexionDataBase implements PermisoLaboralDAO {

    @Override
    public void insert(PermisoLaboral permiso) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO permiso_laboral (cod_permiso,descripcion,fecha,fecha_inicio,fecha_final,cod_doc,cod_admi) VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, permiso.getCod_permiso());
            ps.setString(2, permiso.getDescripcion());
            ps.setDate(3, permiso.getFecha());
            ps.setDate(4, permiso.getFecha_inicio());
            ps.setDate(5, permiso.getFecha_final());
            ps.setString(6, null);
            ps.setString(7, permiso.getCod_admi());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error1: "+e);
        } finally {
            this.desconectar();
        }
    }
    @Override
    public void insert2(PermisoLaboral permiso) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO permiso_laboral (cod_permiso,descripcion,fecha,fecha_inicio,fecha_final,cod_doc,cod_admi) VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, permiso.getCod_permiso());
            ps.setString(2, permiso.getDescripcion());
            ps.setDate(3, permiso.getFecha());
            ps.setDate(4, permiso.getFecha_inicio());
            ps.setDate(5, permiso.getFecha_final());
            ps.setString(6, permiso.getCod_doc());
            ps.setString(7, null);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error1: "+e);
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(PermisoLaboral permiso) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE permiso_laboral SET descripcion=?,fecha=?,fecha_inicio=?,fecha_final=?,cod_doc=?,cod_admi=? WHERE cod_permiso=?");
            
            ps.setString(1, permiso.getDescripcion());
            ps.setDate(2, permiso.getFecha());
            ps.setDate(3, permiso.getFecha_inicio());
            ps.setDate(4, permiso.getFecha_final());
            ps.setString(5, null);
            ps.setString(6, permiso.getCod_admi());
            ps.setString(7, permiso.getCod_permiso());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error2.1: "+e);
        } finally {
            this.desconectar();
        }
    }
    @Override
    public void update2(PermisoLaboral permiso) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE permiso_laboral SET descripcion=?,fecha=?,fecha_inicio=?,fecha_final=?,cod_doc=?,cod_admi=? WHERE cod_permiso=?");
            
            ps.setString(1, permiso.getDescripcion());
            ps.setDate(2, permiso.getFecha());
            ps.setDate(3, permiso.getFecha_inicio());
            ps.setDate(4, permiso.getFecha_final());
            ps.setString(5, permiso.getCod_doc());
            ps.setString(6, null);
            ps.setString(7, permiso.getCod_permiso());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error2.2: "+e);
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(String cod_permiso) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM permiso_laboral WHERE cod_permiso=?");
            ps.setString(1, cod_permiso);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error3: "+e);
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<PermisoLaboral> getAll() throws Exception {
        List<PermisoLaboral> lista = null;
        try {
            this.conectar();
            String sql="SELECT pl.*,CONCAT(d.nombre,' ',d.apellidos) as Docente, CONCAT(pa.nombre ,' ',PA.apellidos) as Personal FROM permiso_laboral pl LEFT JOIN docentes d ON pl.cod_doc = d.cod_doc LEFT JOIN personal_administrativo pa ON pl.cod_admi = pa.cod_admi";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<PermisoLaboral>();
            while (rs.next()) {
                PermisoLaboral per_lab = new PermisoLaboral();

                per_lab.setCod_permiso(rs.getString("cod_permiso"));
                per_lab.setDescripcion(rs.getString("descripcion"));
                per_lab.setFecha(rs.getDate("fecha"));
                per_lab.setFecha_inicio(rs.getDate("fecha_inicio"));
                per_lab.setFecha_final(rs.getDate("fecha_final"));
                
                per_lab.setCod_doc(rs.getString("cod_doc"));
                per_lab.setCod_admi(rs.getString("cod_admi"));
                
                per_lab.setDocente(rs.getString("docente"));
                per_lab.setPersonal(rs.getString("personal"));
                
                lista.add(per_lab);
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
    public PermisoLaboral getById(String cod_permiso) throws Exception {
        PermisoLaboral per_lab = new PermisoLaboral();
        try {
            this.conectar();
            String sql = "select * from permiso_laboral where cod_permiso=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, cod_permiso);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                per_lab.setCod_permiso(rs.getString("cod_permiso"));
                per_lab.setDescripcion(rs.getString("descripcion"));
                per_lab.setFecha(rs.getDate("fecha"));
                per_lab.setFecha_inicio(rs.getDate("fecha_inicio"));
                per_lab.setFecha_final(rs.getDate("fecha_final"));
                
                per_lab.setCod_doc(rs.getString("cod_doc"));
                per_lab.setCod_admi(rs.getString("cod_admi"));
            }
        } catch (SQLException e) {
            System.out.println("error5: "+e);
        } finally {
            this.desconectar();
        }
        return per_lab;
    }

    @Override
    public List<PermisoLaboral> buscar(String texto) throws Exception {
        List<PermisoLaboral> lista = new ArrayList<>();
        String sql = "SELECT pl.*,CONCAT(d.nombre,' ',d.apellidos) as docente FROM permiso_laboral pl, docentes d WHERE pl.cod_doc = d.cod_doc AND (pl.cod_permiso like '%"+texto+"%' OR pl.descripcion like '%"+texto+"%' OR pl.fecha like '%"+texto+"%' OR d.nombre like '%"+texto+"%' OR d.apellidos like '%"+texto+"%') ";
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                PermisoLaboral per_lab = new PermisoLaboral();
                per_lab.setCod_permiso(rs.getString("cod_permiso"));
                per_lab.setDescripcion(rs.getString("descripcion"));
                per_lab.setFecha(rs.getDate("fecha"));
                per_lab.setFecha_inicio(rs.getDate("fecha_inicio"));
                per_lab.setFecha_final(rs.getDate("fecha_final"));
                
                per_lab.setCod_doc(rs.getString("cod_doc"));

                per_lab.setDocente(rs.getString("docente"));

                lista.add(per_lab);
            }
        }catch(Exception e){
        }
        return lista;
    }

    @Override
    public List<PermisoLaboral> buscar2(String texto) throws Exception {
        List<PermisoLaboral> lista = new ArrayList<>();
        String sql = "SELECT pl.*,CONCAT(pa.nombre ,' ',pa.apellidos) as personal FROM permiso_laboral pl, personal_administrativo pa WHERE pl.cod_admi = pa.cod_admi AND (pl.cod_permiso like '%"+texto+"%' OR pl.descripcion like '%"+texto+"%' OR pl.fecha like '%"+texto+"%' OR pa.nombre like '%"+texto+"%' OR pa.apellidos like '%"+texto+"%') ";
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                PermisoLaboral per_lab = new PermisoLaboral();
                per_lab.setCod_permiso(rs.getString("cod_permiso"));
                per_lab.setDescripcion(rs.getString("descripcion"));
                per_lab.setFecha(rs.getDate("fecha"));
                per_lab.setFecha_inicio(rs.getDate("fecha_inicio"));
                per_lab.setFecha_final(rs.getDate("fecha_final"));
                
                per_lab.setCod_doc(rs.getString("cod_admi"));

                per_lab.setPersonal(rs.getString("personal"));

                lista.add(per_lab);
            }
        }catch(Exception e){
        }
        return lista;
    }
}
