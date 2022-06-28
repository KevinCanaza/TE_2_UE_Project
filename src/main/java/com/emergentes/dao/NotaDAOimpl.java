package com.emergentes.dao;

import com.emergentes.modelo.Nota;
import com.emergentes.utiles.ConexionDataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotaDAOimpl extends ConexionDataBase implements NotaDAO {

    @Override
    public void insert(Nota nota) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO nota (cod_nota,rude,primer_trimestre,segundo_trimestre,tercer_trimestre) values (?,?,?,?,?)");

            ps.setString(1, nota.getCod_nota());
            ps.setString(2, nota.getRude());
            ps.setInt(3, nota.getPrimer_trimestre());
            ps.setInt(4, nota.getSegundo_trimestre());
            ps.setInt(5, nota.getTercer_trimestre());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Nota nota) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE nota SET rude=?,primer_trimestre=?,segundo_trimestre=?,tercer_trimestre=? WHERE cod_nota=?");

            ps.setString(1, nota.getRude());
            ps.setInt(2, nota.getPrimer_trimestre());
            ps.setInt(3, nota.getSegundo_trimestre());
            ps.setInt(4, nota.getTercer_trimestre());
            ps.setString(5, nota.getCod_nota());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(String cod_nota) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM nota WHERE cod_nota=?");
            ps.setString(1, cod_nota);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Nota> getAll() throws Exception {
        List<Nota> lista = null;
        try {
            this.conectar();
            String sql = "SELECT n.*,CONCAT(e.nombre,' ',e.apellidos) as estudiante ,(primer_trimestre+segundo_trimestre+tercer_trimestre)/3 as promedio FROM nota n LEFT JOIN estudiantes e ON n.rude=e.rude ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Nota>();
            while (rs.next()) {
                Nota n = new Nota();
                n.setCod_nota(rs.getString("cod_nota"));
                n.setRude(rs.getString("rude"));
                n.setPrimer_trimestre(rs.getInt("primer_trimestre"));
                n.setSegundo_trimestre(rs.getInt("segundo_trimestre"));
                n.setTercer_trimestre(rs.getInt("tercer_trimestre"));
                n.setEstudiante(rs.getString("estudiante"));
                n.setPromedio(rs.getInt("promedio"));
                lista.add(n);
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
    public Nota getById(String cod_nota) throws Exception {
        Nota n = new Nota();
        try {
            this.conectar();
            String sql = "select * from nota where cod_nota=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, cod_nota);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                n.setCod_nota(rs.getString("cod_nota"));
                n.setRude(rs.getString("rude"));
                n.setPrimer_trimestre(rs.getInt("primer_trimestre"));
                n.setSegundo_trimestre(rs.getInt("segundo_trimestre"));
                n.setTercer_trimestre(rs.getInt("tercer_trimestre"));

            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            this.desconectar();
        }
        return n;
    }

    @Override
    public List<Nota> buscar(String texto) throws Exception {
        List<Nota> lista = new ArrayList<>();
        String sql = "SELECT n.*,CONCAT(e.nombre,' ',e.apellidos) as estudiante ,(primer_trimestre+segundo_trimestre+tercer_trimestre)/3 as promedio FROM nota n,estudiantes e WHERE (n.cod_nota like '%" + texto + "%' OR e.nombre like '%" + texto + "%' OR e.apellidos like '%" + texto + "%') AND n.rude=e.rude";
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next()) {
                Nota n = new Nota();
                n.setCod_nota(rs.getString("cod_nota"));
                n.setRude(rs.getString("rude"));
                n.setPrimer_trimestre(rs.getInt("primer_trimestre"));
                n.setSegundo_trimestre(rs.getInt("segundo_trimestre"));
                n.setTercer_trimestre(rs.getInt("tercer_trimestre"));
                n.setEstudiante(rs.getString("estudiante"));
                n.setPromedio(rs.getInt("promedio"));
                lista.add(n);
            }
        } catch (Exception e) {
        }
        return lista;

    }
}
