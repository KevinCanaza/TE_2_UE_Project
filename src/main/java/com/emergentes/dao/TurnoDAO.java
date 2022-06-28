package com.emergentes.dao;

import com.emergentes.modelo.Turno;
import java.util.List;

public interface TurnoDAO {

    public void insert(Turno turno) throws Exception;

    public void update(Turno turno) throws Exception;

    public void delete(String cod_turno) throws Exception;

    public List<Turno> getAll() throws Exception;

    public Turno getById(String cod_turno) throws Exception;
    
    public List<Turno> buscar (String texto) throws Exception;

}
