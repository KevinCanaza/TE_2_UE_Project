
package com.emergentes.dao;

import com.emergentes.modelo.Estudiantes;
import java.util.List;


public interface EstudiantesDAO {
    public void insert(Estudiantes estudiante) throws Exception;
    public void update(Estudiantes estudiante) throws Exception;
    public void delete(String rude) throws Exception;
    public List<Estudiantes> getAll() throws Exception;
    public Estudiantes getById(String rude) throws Exception;
    public List<Estudiantes> buscar (String texto) throws Exception;
}
