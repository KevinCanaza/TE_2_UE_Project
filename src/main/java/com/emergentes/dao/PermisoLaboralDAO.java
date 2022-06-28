package com.emergentes.dao;

import com.emergentes.modelo.PermisoLaboral;
import java.util.List;

public interface PermisoLaboralDAO {
    public void insert(PermisoLaboral permiso) throws Exception;
    public void insert2(PermisoLaboral permiso) throws Exception;
    public void update(PermisoLaboral permiso) throws Exception;
    public void update2(PermisoLaboral permiso) throws Exception;
    public void delete(String cod_permiso) throws Exception;
    public List<PermisoLaboral> getAll() throws Exception;
    public PermisoLaboral getById(String cod_permiso) throws Exception;
    public List<PermisoLaboral> buscar (String texto) throws Exception;
    public List<PermisoLaboral> buscar2 (String texto) throws Exception;
}
