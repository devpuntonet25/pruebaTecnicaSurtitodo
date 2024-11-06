package com.hgallgo.prueba.service;

import com.hgallgo.prueba.dao.IDao;
import com.hgallgo.prueba.dao.PersonaDaoMySQL;
import com.hgallgo.prueba.model.Persona;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {
    private IDao<Persona> personaIDao;

    public PersonaService() {
        personaIDao = new PersonaDaoMySQL();
    }

    public Persona save(Persona persona) {
        return personaIDao.save(persona);
    }

    public Persona findById(Integer id) {
        return personaIDao.findById(id);
    }

    public Persona update(Persona persona) {
        return personaIDao.update(persona);
    }

    public Persona delete(Integer id) {
        return personaIDao.delete(id);
    }

    public List<Persona> findAll() {
        return personaIDao.findAll();
    }

}
