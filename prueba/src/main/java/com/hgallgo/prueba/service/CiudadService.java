package com.hgallgo.prueba.service;

import com.hgallgo.prueba.dao.CiudadDaoMySQL;
import com.hgallgo.prueba.dao.IDao;
import com.hgallgo.prueba.model.Ciudad;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadService {
    private IDao<Ciudad> ciudadIDao;

    public CiudadService() {
        ciudadIDao = new CiudadDaoMySQL();
    }

    public List<Ciudad> findAll() {
        return ciudadIDao.findAll();
    }
}
