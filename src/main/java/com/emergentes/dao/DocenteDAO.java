package com.emergentes.dao;

import com.emergentes.modelo.Docente;
import java.util.List;

public interface DocenteDAO {
    public void insert(Docente docente) throws Exception;
    public void update(Docente docente) throws Exception;
    public void delete(String cod_doc) throws Exception;
    public List<Docente> getAll() throws Exception;
    public Docente getById(String cod_doc) throws Exception;
    public List<Docente> buscar (String texto) throws Exception;
}
