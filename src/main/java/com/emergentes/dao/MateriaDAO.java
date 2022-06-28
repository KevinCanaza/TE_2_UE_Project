package com.emergentes.dao;

import com.emergentes.modelo.Materia;
import java.util.List;

public interface MateriaDAO {
    public void insert(Materia materia) throws Exception;
    public void update(Materia materia) throws Exception;
    public void delete(String cod_mat) throws Exception;
    public List<Materia> getAll() throws Exception;
    public Materia getById(String cod_mat) throws Exception;
    public List<Materia> buscar (String texto) throws Exception;
}
