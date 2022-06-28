package com.emergentes.dao;

import com.emergentes.modelo.Docente;
import com.emergentes.utiles.ConexionDataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DocenteDAOimpl extends ConexionDataBase implements DocenteDAO {

    @Override
    public void insert(Docente docente) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO docentes (cod_doc,nombre,apellidos,ci,direccion,fecha_nac,telefono,cod_mat,cod_grado) VALUES (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, docente.getCod_doc());
            ps.setString(2, docente.getNombre());
            ps.setString(3, docente.getApellidos());
            ps.setString(4, docente.getCi());
            ps.setString(5, docente.getDireccion());
            ps.setDate(6, docente.getFecha_nac());
            ps.setString(7, docente.getTelefono());
            ps.setString(8, docente.getCod_mat());
            ps.setString(9, docente.getCod_grado());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error1: "+e);
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Docente docente) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE docentes SET nombre=?,apellidos=?,ci=?,direccion=?,fecha_nac=?,telefono=?,cod_mat=?,cod_grado=? WHERE cod_doc=?");
            
            ps.setString(1, docente.getNombre());
            ps.setString(2, docente.getApellidos());
            ps.setString(3, docente.getCi());
            ps.setString(4, docente.getDireccion());
            ps.setDate(5, docente.getFecha_nac());
            ps.setString(6, docente.getTelefono());
            ps.setString(7, docente.getCod_mat());
            ps.setString(8, docente.getCod_grado());
            ps.setString(9, docente.getCod_doc());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error2: "+e);
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(String cod_doc) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM docentes WHERE cod_doc=?");
            ps.setString(1, cod_doc);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error3: "+e);
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Docente> getAll() throws Exception {
        List<Docente> lista = null;
        try {
            this.conectar();
            String sql="SELECT d.*,m.descripcion as materia, g.descripcion as grado FROM docentes d LEFT JOIN materias m ON d.cod_mat = m.cod_mat LEFT JOIN grado g ON d.cod_grado = g.cod_grado";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Docente>();
            while (rs.next()) {
                Docente doc = new Docente();

                doc.setCod_doc(rs.getString("cod_doc"));
                doc.setNombre(rs.getNString("nombre"));
                doc.setApellidos(rs.getString("apellidos"));
                doc.setCi(rs.getString("ci"));
                doc.setDireccion(rs.getString("direccion"));
                doc.setFecha_nac(rs.getDate("fecha_nac"));
                doc.setTelefono(rs.getString("telefono"));
                
                doc.setCod_mat(rs.getString("cod_mat"));
                doc.setCod_grado(rs.getString("cod_grado"));
                
                doc.setMateria(rs.getString("materia"));
                doc.setGrado(rs.getString("grado"));
                
                lista.add(doc);
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
    public Docente getById(String cod_doc) throws Exception {
        Docente doc = new Docente();
        try {
            this.conectar();
            String sql = "select * from docentes where cod_doc=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, cod_doc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                doc.setCod_doc(rs.getString("cod_doc"));
                doc.setNombre(rs.getNString("nombre"));
                doc.setApellidos(rs.getString("apellidos"));
                doc.setCi(rs.getString("ci"));
                doc.setDireccion(rs.getString("direccion"));
                doc.setFecha_nac(rs.getDate("fecha_nac"));
                doc.setTelefono(rs.getString("telefono"));
                
                doc.setCod_mat(rs.getString("cod_mat"));
                doc.setCod_grado(rs.getString("cod_grado"));
            }
        } catch (SQLException e) {
            System.out.println("error5: "+e);
        } finally {
            this.desconectar();
        }
        return doc;
    }

    @Override
    public List<Docente> buscar(String texto) throws Exception {
        List<Docente> lista = new ArrayList<>();
        String sql = "SELECT d.*,m.descripcion as materia, g.descripcion as grado FROM docentes d,materias m,grado g WHERE (d.cod_doc like '%"+texto+"%' or d.nombre like '%"+texto+"%' or d.apellidos like '%"+texto+"%' or d.ci like '%"+texto+"%' or d.direccion like '%"+texto+"%' or d.fecha_nac like '%"+texto+"%'  or d.telefono like '%"+texto+"%') AND d.cod_mat = m.cod_mat AND d.cod_grado = g.cod_grado";
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                Docente doc = new Docente();
                doc.setCod_doc(rs.getString("cod_doc"));
                doc.setNombre(rs.getNString("nombre"));
                doc.setApellidos(rs.getString("apellidos"));
                doc.setCi(rs.getString("ci"));
                doc.setDireccion(rs.getString("direccion"));
                doc.setFecha_nac(rs.getDate("fecha_nac"));
                doc.setTelefono(rs.getString("telefono"));
                
                doc.setCod_mat(rs.getString("cod_mat"));
                doc.setCod_grado(rs.getString("cod_grado"));
                
                doc.setMateria(rs.getString("materia"));
                doc.setGrado(rs.getString("grado"));
                lista.add(doc);
            }
        }catch(Exception e){
        }
        return lista;
    }
}
