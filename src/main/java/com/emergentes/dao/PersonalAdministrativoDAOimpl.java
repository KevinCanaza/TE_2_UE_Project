package com.emergentes.dao;

import com.emergentes.modelo.PersonalAdministrativo;
import com.emergentes.utiles.ConexionDataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonalAdministrativoDAOimpl extends ConexionDataBase implements PersonalAdministrativoDAO {

    @Override
    public void insert(PersonalAdministrativo personal) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO personal_administrativo (cod_admi,nombre,apellidos,ci,fecha_nac,direccion,telefono,cargo) VALUES (?,?,?,?,?,?,?,?)");
            ps.setString(1, personal.getCod_admi());
            ps.setString(2, personal.getNombre());
            ps.setString(3, personal.getApellidos());
            ps.setString(4, personal.getCi());
            ps.setDate(5, personal.getFecha_nac());
            ps.setString(6, personal.getDireccion());
            ps.setString(7, personal.getTelefono());
            ps.setString(8,personal.getCargo());
            
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error1: "+e);
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(PersonalAdministrativo personal) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE personal_administrativo SET nombre=?,apellidos=?,ci=?,fecha_nac=?,direccion=?,telefono=?,cargo=? WHERE cod_admi=?");
            
            ps.setString(1, personal.getNombre());
            ps.setString(2, personal.getApellidos());
            ps.setString(3, personal.getCi());
            ps.setDate(4, personal.getFecha_nac());
            ps.setString(5, personal.getDireccion());
            ps.setString(6, personal.getTelefono());
            ps.setString(7, personal.getCargo());
            ps.setString(8, personal.getCod_admi());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error2: "+e);
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(String cod_admi) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM personal_administrativo WHERE cod_admi=?");
            ps.setString(1, cod_admi);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error3: "+e);
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<PersonalAdministrativo> getAll() throws Exception {
        List<PersonalAdministrativo> lista = null;
        try {
            this.conectar();
            String sql="SELECT * FROM personal_administrativo";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<PersonalAdministrativo>();
            while (rs.next()) {
                PersonalAdministrativo per = new PersonalAdministrativo();

                per.setCod_admi(rs.getString("cod_admi"));
                per.setNombre(rs.getNString("nombre"));
                per.setApellidos(rs.getString("apellidos"));
                per.setCi(rs.getString("ci"));
                per.setFecha_nac(rs.getDate("fecha_nac"));
                per.setDireccion(rs.getString("direccion"));
                per.setTelefono(rs.getString("telefono"));
                per.setCargo(rs.getString("cargo"));
                
                lista.add(per);
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
    public PersonalAdministrativo getById(String cod_admi) throws Exception {
        PersonalAdministrativo per = new PersonalAdministrativo();
        try {
            this.conectar();
            String sql = "select * from personal_administrativo where cod_admi=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, cod_admi);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                per.setCod_admi(rs.getString("cod_admi"));
                per.setNombre(rs.getNString("nombre"));
                per.setApellidos(rs.getString("apellidos"));
                per.setCi(rs.getString("ci"));
                per.setFecha_nac(rs.getDate("fecha_nac"));
                per.setDireccion(rs.getString("direccion"));
                per.setTelefono(rs.getString("telefono"));
                per.setCargo(rs.getString("cargo"));
            }
        } catch (SQLException e) {
            System.out.println("error5: "+e);
        } finally {
            this.desconectar();
        }
        return per;
    }

    @Override
    public List<PersonalAdministrativo> buscar(String texto) throws Exception {
        List<PersonalAdministrativo> lista = new ArrayList<>();
        String sql = "select * from personal_administrativo where cod_admi like '%"+texto+"%' or nombre like '%"+texto+"%' or apellidos like '%"+texto+"%' or ci like '%"+texto+"%' or fecha_nac like '%"+texto+"%' or direccion like '%"+texto+"%' or telefono like '%"+texto+"%' or cargo like '%"+texto+"%'";
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                PersonalAdministrativo per = new PersonalAdministrativo();
                per.setCod_admi(rs.getString("cod_admi"));
                per.setNombre(rs.getNString("nombre"));
                per.setApellidos(rs.getString("apellidos"));
                per.setCi(rs.getString("ci"));
                per.setFecha_nac(rs.getDate("fecha_nac"));
                per.setDireccion(rs.getString("direccion"));
                per.setTelefono(rs.getString("telefono"));
                per.setCargo(rs.getString("cargo"));
                lista.add(per);
            }
        }catch(Exception e){
        }
        return lista;
    }
}
