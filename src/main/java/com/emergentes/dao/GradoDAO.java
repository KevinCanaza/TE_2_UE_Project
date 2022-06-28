package com.emergentes.dao;

import com.emergentes.modelo.Grado;
import java.util.List;

public interface GradoDAO {

    public void insert(Grado grado) throws Exception;

    public void update(Grado grado) throws Exception;

    public void delete(String cod_grado) throws Exception;

    public List<Grado> getAll() throws Exception;

    public Grado getById(String cod_grado) throws Exception;
    
    public List<Grado> buscar (String texto) throws Exception;

}
