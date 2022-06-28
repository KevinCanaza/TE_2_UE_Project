
package com.emergentes.dao;

import com.emergentes.modelo.Paralelo;
import java.util.List;

public interface ParaleloDAO {
    public void insert(Paralelo paralelo) throws Exception;

    public void update(Paralelo paralelo) throws Exception;

    public void delete(String cod_paralelo) throws Exception;

    public List<Paralelo> getAll() throws Exception;

    public Paralelo getById(String cod_paralelo) throws Exception;
       public List<Paralelo> buscar (String texto) throws Exception;
    
}
