package com.emergentes.dao;

import com.emergentes.modelo.PersonalAdministrativo;
import java.util.List;

public interface PersonalAdministrativoDAO {
    public void insert(PersonalAdministrativo personal) throws Exception;
    public void update(PersonalAdministrativo personal) throws Exception;
    public void delete(String cod_admi) throws Exception;
    public List<PersonalAdministrativo> getAll() throws Exception;
    public PersonalAdministrativo getById(String cod_admi) throws Exception;
    public List<PersonalAdministrativo> buscar (String texto) throws Exception;
}
