package com.emergentes.dao;

import com.emergentes.modelo.PPFF;
import java.util.List;

public interface PPFFDAO {

    public void insert(PPFF ppff) throws Exception;

    public void update(PPFF ppff) throws Exception;

    public void delete(String id) throws Exception;

    public List<PPFF> getAll() throws Exception;

    public PPFF getById(String id) throws Exception;
    
    public List<PPFF> buscar (String texto) throws Exception;
}
