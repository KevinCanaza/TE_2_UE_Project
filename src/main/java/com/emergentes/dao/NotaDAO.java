package com.emergentes.dao;

import com.emergentes.modelo.Nota;
import java.util.List;

public interface NotaDAO {

    public void insert(Nota nota) throws Exception;

    public void update(Nota nota) throws Exception;

    public void delete(String cod_nota) throws Exception;

    public List<Nota> getAll() throws Exception;

    public Nota getById(String cod_nota) throws Exception;

    public List<Nota> buscar (String texto) throws Exception;
}
