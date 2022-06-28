package com.emergentes.dao;

import com.emergentes.modelo.Inscripcion;
import java.util.List;

public interface InscripcionDAO {

    public void insert(Inscripcion inscripcion) throws Exception;

    public void update(Inscripcion inscripcion) throws Exception;

    public void delete(String cod_inscripcion) throws Exception;

    public List<Inscripcion> getAll() throws Exception;

    public Inscripcion getById(String cod_inscripcion) throws Exception;

    
    public List<Inscripcion> buscar (String texto) throws Exception;
}
